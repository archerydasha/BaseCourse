package com.basecourse.actions;
/**
 * Created by dshcherbyna on 26.02.14.
 */

import com.basecourse.actions.jaxb.DataClass;
import com.basecourse.actions.jaxb.DataContainer;
import com.basecourse.services.FeedService;
import com.google.common.base.Throwables;
import com.google.common.io.Files;
import com.google.inject.Inject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;

public class FeedNotificatonAction extends Action {
    private FeedService service;

    @Inject
    public FeedNotificatonAction(FeedService service) {
        eventType = EventType.FEED_EVENT;
        this.service = service;
        System.out.println("com.basecourse.services.FeedNotificationAction was instantiated with Guice");
    }

    @Override
    void processEvent(Properties properties) {
        File tempDirectory = Files.createTempDir();
        InputStream feedInputStream = this.getClass().getResourceAsStream(properties.getFeedFileName());
        ZipUnpacker unpacker = new ZipUnpacker();
        unpacker.unpackZipFile(feedInputStream, tempDirectory);

        DataContainer container = getDataContainer(tempDirectory, "meta.xml");

        if (!checkMissingFiles(tempDirectory, container)) {
            return;
        }

        service.createFeed(properties.getFeedFileName(), container.getContainerType());
    }

    private DataContainer getDataContainer(File tempDirectory, String filename) {
        InputStream inputStream = null;
        DataContainer container = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(tempDirectory, filename)));
            JAXBContext context = JAXBContext.newInstance(DataContainer.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<DataContainer> element = unmarshaller.unmarshal(new StreamSource(inputStream), DataContainer.class);
            container = element.getValue();
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
        return container;
    }

    private boolean checkMissingFiles(File tempDirectory, DataContainer container) {
        ArrayList<String> missingFiles = new ArrayList<String>();
        for (DataClass data : container.getDataClass()) {
            File dataFile = new File(tempDirectory, data.getContainerFile().getRelativeURI());
            if (!dataFile.exists()) {
                missingFiles.add(dataFile.getPath());
            }
        }
        if (missingFiles.size() > 0) {
            System.out.println("Feed is corrupted! Following files are missing:");
            System.out.println(missingFiles);
            return false;
        }
        return true;
    }
}