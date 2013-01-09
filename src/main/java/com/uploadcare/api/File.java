package com.uploadcare.api;

import com.uploadcare.data.FileData;
import com.uploadcare.urls.CdnPathBuilder;

import java.net.URI;
import java.util.Date;

public class File {

    private Client client;
    private FileData fileData;

    File(Client client, FileData fileData) {
        this.client = client;
        this.fileData = fileData;
    }

    public String getFileId() {
        return fileData.fileId;
    }

    public boolean isStored() {
        return fileData.lastKeepClaim != null;
    }

    public Date getLastKeepClaim() {
        return fileData.lastKeepClaim;
    }

    public boolean isMadePublic() {
        return fileData.madePublic;
    }

    public String getMimeType() {
        return fileData.mimeType;
    }

    public boolean isOnS3() {
        return fileData.onS3;
    }

    public boolean hasOriginalFileUrl() {
        return fileData.originalFileUrl != null;
    }

    public URI getOriginalFileUrl() {
        return fileData.originalFileUrl;
    }

    public String getOriginalFilename() {
        return fileData.originalFilename;
    }

    public boolean isRemoved() {
        return fileData.removed != null;
    }

    public Date getRemoved() {
        return fileData.removed;
    }

    public int getSize() {
        return fileData.size;
    }

    public Date getUploadDate() {
        return fileData.uploadDate;
    }

    public URI getUrl() {
        return fileData.url;
    }

    public File update() {
        fileData = client.getFile(fileData.fileId).fileData;
        return this;
    }

    public File delete() {
        client.deleteFile(fileData.fileId);
        update();
        return this;
    }

    public File save() {
        client.saveFile(fileData.fileId);
        update();
        return this;
    }

    public CdnPathBuilder cdnPath() {
        return new CdnPathBuilder(this);
    }
}