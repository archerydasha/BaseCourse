package com.basecourse.actions;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by dshcherbyna on 03.03.14.
 */
public class ZipUnpacker {
    private ZipUnpacker() {
    }

    public static void unpackZipFile(InputStream zipStream, File rootDirectory) {
        String rootDirectoryName = checkRootDirectory(rootDirectory);

        ZipInputStream feedZipStream = null;
        ZipEntry entry;
        try {
            feedZipStream = new ZipInputStream(zipStream);
            while ((entry = feedZipStream.getNextEntry()) != null) {
                File destinationFile = new File(rootDirectoryName, entry.getName());
                unpackEntry(destinationFile, feedZipStream);
                feedZipStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (feedZipStream != null) {
                try {
                    feedZipStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static String checkRootDirectory(File rootDirectory) {
        //ToDo - maybe find a better behaviour for this situation
        if (rootDirectory == null || (rootDirectory.exists() && !rootDirectory.isDirectory())) {
            System.out.println(rootDirectory.getName() + " is not a directory, current directory used instead");
            return ".";
        }
        if (!rootDirectory.exists()) {
            rootDirectory.mkdirs();
        }
        return rootDirectory.getPath();
    }

    private static void unpackEntry(File destinationFile, ZipInputStream feedZipStream) {
//        createParentFolder(destinationFile);
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(destinationFile));
            for (int c = feedZipStream.read(); c != -1; c = feedZipStream.read()) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

/*
        private static void createParentFolder(File destinationFile) {
        File parent = new File(destinationFile.getParent());
        parent.mkdirs();
    }
*/
}
