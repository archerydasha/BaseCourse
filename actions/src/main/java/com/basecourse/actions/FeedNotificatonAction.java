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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;

public class FeedNotificatonAction extends Action {
    private FeedService service;
    private static Log LOG = LogFactory.getLog(FeedNotificatonAction.class);

    @Inject
    public FeedNotificatonAction(FeedService service) {
        eventType = EventType.FEED_EVENT;
        this.service = service;
        LOG.info("FeedNotificationAction was instantiated with Guice");
    }

    @Override
    void processEvent(String propertyString) {

    }

    @Override
    void processEvent(Properties properties) {
        LOG.info("processEvent function called");
        File tempDirectory = Files.createTempDir();
        LOG.info("Using temp directory " + tempDirectory.getPath());
        LOG.info("Unpacking file " + properties.getFeedFileName());
        InputStream feedInputStream = this.getClass().getResourceAsStream(properties.getFeedFileName());
        ZipUnpacker unpacker = new ZipUnpacker();
        unpacker.unpackZipFile(feedInputStream, tempDirectory);

        LOG.info("Creating DataContainer from meta.xml");
        DataContainer container = getDataContainer(tempDirectory, "meta.xml");

        LOG.info("Checking that the feed is not corrupted");
        if (!checkMissingFiles(tempDirectory, container)) {
            return;
        }

        LOG.info("Starting feed creation");
        for(DataClass dataClass : container.getDataClass()){
            service.createFeed(dataClass.getContainerFile().getRelativeURI(), dataClass.getContainerFile().getChecksum());
        }
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
            LOG.info("Feed is corrupted! Following files are missing:");
            LOG.info(missingFiles);
            return false;
        }
        return true;
    }
}