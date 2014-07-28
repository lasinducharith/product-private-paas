/*
 * Licensed to the Apache Software Foundation (ASF) under one 
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied.  See the License for the 
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.stratos.autoscaler.policy.model;

import java.io.Serializable;

/**
 * The model class for LoadAverage definition.
 */
public class LoadAverageThresholds implements Serializable{

	private static final long serialVersionUID = -2109860338694123343L;
	private float upperLimit = 80.0F;
	private float lowerLimit = 20.0F;
	
	public float getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(float upperLimit) {
		this.upperLimit = upperLimit;
	}
	public float getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(float lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	
	@Override
	public String toString() {
		return "LoadAverage [upperLimit=" + upperLimit + ", lowerLimit="
				+ lowerLimit + "]";
	}

}