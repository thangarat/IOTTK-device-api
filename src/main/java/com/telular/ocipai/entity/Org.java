package com.telular.ocipai.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "org")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Org {
	@Id
	@Column(name = "org_id")
	public Long org_id;
	@Column(name = "parent_org_id")
	public Long parent_org_id;
	@Column(name = "org_abbrev")
	public String org_abbrev;
	@Column(name = "org_name")
	public String org_name;
	@Column(name = "org_type")
	public String org_type;
	@Column(name = "org_status")
	public String org_status;
	@Column(name = "location_id")
	public Long location_id;
	@Column(name = "create_dt")
	public LocalDateTime create_dt;

}
