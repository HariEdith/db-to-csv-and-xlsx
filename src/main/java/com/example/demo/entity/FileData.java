package com.example.demo.entity;
import java.sql.Clob;
import java.time.LocalDateTime;

public class FileData {
	private String id;
	private String referanceId;
	private String typeCode;
	private String subTypeCode;
	private String activeCode;
	private String stageCode;
	private String statusCode;
	private String processId;
	private String createdOn;
	private int createdBy;
	private String lastUpdatedOn;
	private int lastUpdatedBy;
	private String lastAuthorisedOn;
	private int lastAuthorisedBy;
	private Clob template;
	private String applicationPartyCode;
	private String issuingPartyCode;
	private int isTemplate;
	private String channels;
	private String transferStatus;
	private int layoutTemplateId;
	private String layoutName;
	private byte[] fileContent;
	private String uploadRefId;
	private String FileName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReferanceId() {
		return referanceId;
	}
	public void setReferanceId(String referanceId) {
		this.referanceId = referanceId;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getSubTypeCode() {
		return subTypeCode;
	}
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getStageCode() {
		return stageCode;
	}
	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getLastAuthorisedOn() {
		return lastAuthorisedOn;
	}
	public void setLastAuthorisedOn(String lastAuthorisedOn) {
		this.lastAuthorisedOn = lastAuthorisedOn;
	}
	public int getLastAuthorisedBy() {
		return lastAuthorisedBy;
	}
	public void setLastAuthorisedBy(int lastAuthorisedBy) {
		this.lastAuthorisedBy = lastAuthorisedBy;
	}
	public Clob getTemplate() {
		return template;
	}
	public void setTemplate(Clob template) {
		this.template = template;
	}
	public String getApplicationPartyCode() {
		return applicationPartyCode;
	}
	public void setApplicationPartyCode(String applicationPartyCode) {
		this.applicationPartyCode = applicationPartyCode;
	}
	public String getIssuingPartyCode() {
		return issuingPartyCode;
	}
	public void setIssuingPartyCode(String issuingPartyCode) {
		this.issuingPartyCode = issuingPartyCode;
	}
	public int getIsTemplate() {
		return isTemplate;
	}
	public void setIsTemplate(int isTemplate) {
		this.isTemplate = isTemplate;
	}
	public String getChannels() {
		return channels;
	}
	public void setChannels(String channels) {
		this.channels = channels;
	}
	public String getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}
	public int getLayoutTemplateId() {
		return layoutTemplateId;
	}
	public void setLayoutTemplateId(int layoutTemplateId) {
		this.layoutTemplateId = layoutTemplateId;
	}
	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getUploadRefId() {
		return uploadRefId;
	}
	public void setUploadRefId(String uploadRefId) {
		this.uploadRefId = uploadRefId;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	@Override
	public String toString(){
		return "id ="+id+
				",referanceId ="+referanceId+
				",typeCode ="+typeCode+
				",subTypeCode ="+subTypeCode+
				",activeCode ="+activeCode+
				",stageCode ="+stageCode+
				",statusCode ="+statusCode+
				",processId ="+processId
				+",createdOn ="+createdOn
				+",createdBy ="+createdBy
				+",lastUpdatedOn ="+lastUpdatedOn
				+",lastUpdatedBy ="+lastUpdatedBy
				+",lastAuthorisedOn ="+lastAuthorisedOn
				+",lastAuthorisedBy ="+lastAuthorisedBy
				+",template = "+template
				+",applicationPartyCode ="+applicationPartyCode
				+",issuingPartyCode ="+issuingPartyCode
				+",isTemplate ="+isTemplate
				+",channels = "+channels
				+",transferStatus = "+transferStatus
				+",layoutTemplateId ="+layoutTemplateId
				+",layoutName = "+layoutName
				+",fileContent = "+fileContent
				+",uploadRefId = "+uploadRefId
				+",FileName = "+FileName
				
				;
		
	}

}
