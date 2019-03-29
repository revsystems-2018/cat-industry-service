package com.rev.cat.catservice.domain.file.model;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author rveizaga
 */
@Document
public class DBFile extends GenericDomain {

    private String fileName;

    private String fileType;

    private byte[] data;

    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
