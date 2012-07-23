package com.lacatira.specialevents.model;

import com.lacatira.common.BusinessModel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.util.Calendar;

@JsonAutoDetect
@Entity
@Table(name = "specialevent")
public class SpecialEvent  implements BusinessModel {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 5860748127987410583L;

	private Long id;
	private String name;
	private String description;
	private String category;
	private Calendar startTime;
	private Calendar endTime;
	private Double longitude;
	private Double latitude;
	private String address;
	private Double radius;
	private String url;
	private String  summary;
	private String      iconLink;
	private Long     userId;

	/**

	 * Default constructor - creates a new instance with no values set.

	 */

	 public SpecialEvent() {

	}

	/**
	 * Create a new instance and set the name.
	 *
	 * @param name  name for event.
	 */

	 public SpecialEvent(final String name) {

		 this.name = name;

	 }

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @JsonProperty("id")
	 public Long getId() {
		 return id;
	 }

	 @Column(nullable = false, length = 100)
	 public String getName() {
		 return name;
	 }


	 @Column(name = "description", length = 1000)
	 public String getDescription() {
		 return description;
	 }

	 @JsonProperty("id")
	 public void setId(Long id) {
		 this.id = id;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public void setDescription(String description) {
		 this.description = description;
	 }

	 public String getCategory() {
		 return category;
	 }

	 public void setCategory(String category) {
		 this.category = category;
	 }

	 public Calendar getStartTime() {
		 return startTime;
	 }

	 public void setStartTime(Calendar startTime) {
		 this.startTime = startTime;
	 }

	 public Calendar getEndTime() {
		 return endTime;
	 }

	 public void setEndTime(Calendar endTime) {
		 this.endTime = endTime;
	 }

	 public Double getLongitude() {
		 return longitude;
	 }

	 public void setLongitude(Double longitude) {
		 this.longitude = longitude;
	 }

	 public Double getLatitude() {
		 return latitude;
	 }

	 public void setLatitude(Double latitude) {
		 this.latitude = latitude;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public Double getRadius() {
		 return radius;
	 }

	 public void setRadius(Double radius) {
		 this.radius = radius;
	 }

	 @JsonProperty("externalURL")
	 public String getUrl() {
		 return url;
	 }

	 @JsonProperty("externalURL")
	 public void setUrl(String url) {
		 this.url = url;
	 }

	 @JsonProperty("summary")
	 public String getSummary() {
		 return summary;
	 }

	 @JsonProperty("summary")
	 public void setSummary(String summary) {
		 this.summary = summary;
	 }

	 @JsonProperty("imageLink")
	 public String getIconLink() {
		 return iconLink;
	 }

	 @JsonProperty("imageLink")
	 public void setIconLink(String iconLink) {
		 this.iconLink = iconLink;
	 }

	
	

	public String toString() {
		 ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
		 .append("name", name)
		 .append("description", description)
		 .append("category", category)
		 .append("startTime", startTime)
		 .append("endTime", endTime)
		 .append("longitude", longitude)
		 .append("latitude", latitude)
		 .append("address", address)
		 .append("url", url)
		 .append("summary", summary)
		 .append("iconLink", iconLink)
		 .append("userId", userId);
		 return sb.toString();
	 }

	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialEvent other = (SpecialEvent) obj;
		if (id == null) {
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	  public Long getUserId() {
		  return userId;
	  }

	  public void setUserId(Long userId) {
		  this.userId = userId;
	  }





}
