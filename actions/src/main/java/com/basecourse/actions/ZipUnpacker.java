package com.basecourse.actions;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.ByteStreams;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by dshcherbyna on 03.03.14.
 */
public class ZipUnpacker {
    private Logger LOG = Logger.getLogger(ZipUnpacker.class);

    public void unpackZipFile(InputStream zipStream, File rootDirectory){
        LOG.info("unpackZipFile called");
        LOG.info("Checking root directory");
        Preconditions.checkNotNull(rootDirectory);
        String rootDirectoryName = checkRootDirectory(rootDirectory);

        ZipInputStream feedZipStream = null;
        ZipEntry entry;
        LOG.info("Unpacking started");
        try {
            try {
                feedZipStream = new ZipInputStream(zipStream);
                while ((entry = feedZipStream.getNextEntry()) != null) {
                    File destinationFile = new File(rootDirectoryName, entry.getName());
                    unpackEntry(destinationFile, feedZipStream);
                }
            } finally {
                if (feedZipStream != null) {
                    feedZipStream.close();
                }
            }
        } catch (Exception e) {
            LOG.error("Unpacking failed.", e);
            Throwables.propagate(e);
        }
        LOG.info("Unpacking finished");
    }

    private String checkRootDirectory(File rootDirectory) {
        if (rootDirectory == null || (rootDirectory.exists() && !rootDirectory.isDirectory())) {
            throw new IllegalArgumentException(rootDirectory + " is not a valid directory");
        }
        if (!rootDirectory.exists()) {
            rootDirectory.mkdirs();
        }
        return rootDirectory.getPath();
    }

    private void unpackEntry(File destinationFile, ZipInputStream feedZipStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
        ByteStreams.copy(feedZipStream, fileOutputStream);
    }
}
