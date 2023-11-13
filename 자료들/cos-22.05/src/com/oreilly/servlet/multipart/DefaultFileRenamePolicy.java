// Copyright (C) 2002-2022 by Jason Hunter <jhunter_AT_servlets_DOT_com>.
// All rights reserved.  Use of this class is limited.
// Please see the LICENSE for more information.

package com.oreilly.servlet.multipart;

import java.io.*;

/**
 * Implements a renaming policy that adds increasing integers to the body of
 * any file that collides.  For example, if foo.gif is being uploaded and a
 * file by the same name already exists, this logic will rename the upload
 * foo1.gif.  A second upload by the same name would be foo2.gif.
 * Note that for safety the rename() method creates a zero-length file with
 * the chosen name to act as a marker that the name is taken even before the
 * upload starts writing the bytes.
 */
public class DefaultFileRenamePolicy implements FileRenamePolicy {
  
  // This method does not need to be synchronized because createNewFile()
  // is atomic and used here to mark when a file name is chosen
  public File rename(File f) {
    if (createNewFile(f)) {
      return f;
    }
    String name = f.getName();
    String body = null;
    String ext = null;

    int dot = name.lastIndexOf(".");
    if (dot != -1) {
      body = name.substring(0, dot);
      ext = name.substring(dot);  // includes "."
    }
    else {
      body = name;
      ext = "";
    }

    // Increase the count until an empty spot is found.
    // Max out at 9999 to avoid an infinite loop caused by a persistent
    // IOException, like when the destination dir becomes non-writable.
    // We don't pass the exception up because our job is just to rename,
    // and the caller will hit any IOException in normal processing.
    int count = 0;
    while (!createNewFile(f) && count < 9999) {
      count++;
      String newName = body + count + ext;
      f = new File(f.getParent(), newName);
    }

    return f;
  }

  private boolean createNewFile(File f) {
    try {
      return f.createNewFile();
    }
    catch (IOException ignored) {
      return false;
    }
  }
}
