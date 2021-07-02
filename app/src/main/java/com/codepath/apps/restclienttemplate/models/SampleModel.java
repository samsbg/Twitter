package com.codepath.apps.restclienttemplate.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

 // This is a temporary, sample model that demonstrates the basic structure
 // of a SQLite persisted Model object

@Entity
public class SampleModel {

	@PrimaryKey(autoGenerate = true)
	Long id;

	@ColumnInfo
	private String name;

	public SampleModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
