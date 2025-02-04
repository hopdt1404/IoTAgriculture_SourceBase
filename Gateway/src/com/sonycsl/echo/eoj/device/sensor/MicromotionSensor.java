/*
 * Copyright 2012 Sony Computer Science Laboratories, Inc. <info@kadecot.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sonycsl.echo.eoj.device.sensor;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class MicromotionSensor extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0026;

	public static final byte EPC_DETECTION_THRESHOLD_LEVEL = (byte)0xB0;
	public static final byte EPC_MICROMOTION_DETECTION_STATUS = (byte)0xB1;
	public static final byte EPC_DETECTION_COUNTER = (byte)0xB2;
	public static final byte EPC_SAMPLING_COUNT = (byte)0xBC;
	public static final byte EPC_SAMPLING_CYCLE = (byte)0xBD;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_MICROMOTION_DETECTION_STATUS);
		addGetProperty(EPC_MICROMOTION_DETECTION_STATUS);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewMicromotionSensor(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Detection threshold level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies detection threshold level (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDetectionThresholdLevel(byte[] edt) {return false;}
	/**
	 * Property name : Detection threshold level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies detection threshold level (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDetectionThresholdLevel() {return null;}
	/**
	 * Property name : Detection threshold level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies detection threshold level (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDetectionThresholdLevel(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : Micromotion detection status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether micromotion is detected or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Micromotion detected = 0x41 Micromotion not detected = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getMicromotionDetectionStatus();
	/**
	 * Property name : Micromotion detection status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether micromotion is detected or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Micromotion detected = 0x41 Micromotion not detected = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMicromotionDetectionStatus(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : Detection counter<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDetectionCounter(byte[] edt) {return false;}
	/**
	 * Property name : Detection counter<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDetectionCounter() {return null;}
	/**
	 * Property name : Detection counter<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDetectionCounter(byte[] edt) {
		return edt != null && edt.length == 2;
	}
	/**
	 * Property name : Sampling count<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSamplingCount(byte[] edt) {return false;}
	/**
	 * Property name : Sampling count<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSamplingCount() {return null;}
	/**
	 * Property name : Sampling count<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling count.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSamplingCount(byte[] edt) {
		return edt != null && edt.length == 2;
	}
	/**
	 * Property name : Sampling cycle<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : msec<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSamplingCycle(byte[] edt) {return false;}
	/**
	 * Property name : Sampling cycle<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : msec<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSamplingCycle() {return null;}
	/**
	 * Property name : Sampling cycle<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates micromotion detection sampling cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFE (0.65534)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : msec<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSamplingCycle(byte[] edt) {
		return edt != null && edt.length == 2;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DETECTION_THRESHOLD_LEVEL : return setDetectionThresholdLevel(property.edt);
		case EPC_DETECTION_COUNTER : return setDetectionCounter(property.edt);
		case EPC_SAMPLING_COUNT : return setSamplingCount(property.edt);
		case EPC_SAMPLING_CYCLE : return setSamplingCycle(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DETECTION_THRESHOLD_LEVEL : return getDetectionThresholdLevel();
		case EPC_MICROMOTION_DETECTION_STATUS : return getMicromotionDetectionStatus();
		case EPC_DETECTION_COUNTER : return getDetectionCounter();
		case EPC_SAMPLING_COUNT : return getSamplingCount();
		case EPC_SAMPLING_CYCLE : return getSamplingCycle();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DETECTION_THRESHOLD_LEVEL : return isValidDetectionThresholdLevel(property.edt);
		case EPC_MICROMOTION_DETECTION_STATUS : return isValidMicromotionDetectionStatus(property.edt);
		case EPC_DETECTION_COUNTER : return isValidDetectionCounter(property.edt);
		case EPC_SAMPLING_COUNT : return isValidSamplingCount(property.edt);
		case EPC_SAMPLING_CYCLE : return isValidSamplingCycle(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_DETECTION_THRESHOLD_LEVEL : 
				onSetDetectionThresholdLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_DETECTION_COUNTER : 
				onSetDetectionCounter(eoj, tid, esv, property, success);
				return true;
			case EPC_SAMPLING_COUNT : 
				onSetSamplingCount(eoj, tid, esv, property, success);
				return true;
			case EPC_SAMPLING_CYCLE : 
				onSetSamplingCycle(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_DETECTION_THRESHOLD_LEVEL : 
				onGetDetectionThresholdLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_MICROMOTION_DETECTION_STATUS : 
				onGetMicromotionDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_DETECTION_COUNTER : 
				onGetDetectionCounter(eoj, tid, esv, property, success);
				return true;
			case EPC_SAMPLING_COUNT : 
				onGetSamplingCount(eoj, tid, esv, property, success);
				return true;
			case EPC_SAMPLING_CYCLE : 
				onGetSamplingCycle(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Detection threshold level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies detection threshold level (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDetectionThresholdLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection threshold level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies detection threshold level (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDetectionThresholdLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Micromotion detection status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether micromotion is detected or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Micromotion detected = 0x41 Micromotion not detected = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMicromotionDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection counter<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDetectionCounter(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection counter<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDetectionCounter(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sampling count<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSamplingCount(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sampling count<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSamplingCount(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sampling cycle<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : msec<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSamplingCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sampling cycle<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : msec<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSamplingCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		
		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			return (Setter)super.reqSetOperationStatus(edt);
		}
		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}
		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimitSetting(edt);
		}
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			return (Setter)super.reqSetPowerSavingOperationSetting(edt);
		}
		@Override
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
		}
		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentTimeSetting(edt);
		}
		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentDateSetting(edt);
		}
		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			return (Setter)super.reqSetPowerLimitSetting(edt);
		}
		
		/**
		 * Property name : Detection threshold level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies detection threshold level (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDetectionThresholdLevel(byte[] edt) {
			reqSetProperty(EPC_DETECTION_THRESHOLD_LEVEL, edt);
			return this;
		}
		/**
		 * Property name : Detection counter<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDetectionCounter(byte[] edt) {
			reqSetProperty(EPC_DETECTION_COUNTER, edt);
			return this;
		}
		/**
		 * Property name : Sampling count<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSamplingCount(byte[] edt) {
			reqSetProperty(EPC_SAMPLING_COUNT, edt);
			return this;
		}
		/**
		 * Property name : Sampling cycle<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : msec<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSamplingCycle(byte[] edt) {
			reqSetProperty(EPC_SAMPLING_CYCLE, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
		@Override
		public Getter reqGetOperationStatus() {
			return (Getter)super.reqGetOperationStatus();
		}
		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}
		@Override
		public Getter reqGetStandardVersionInformation() {
			return (Getter)super.reqGetStandardVersionInformation();
		}
		@Override
		public Getter reqGetIdentificationNumber() {
			return (Getter)super.reqGetIdentificationNumber();
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			return (Getter)super.reqGetMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			return (Getter)super.reqGetMeasuredCumulativePowerConsumption();
		}
		@Override
		public Getter reqGetManufacturersFaultCode() {
			return (Getter)super.reqGetManufacturersFaultCode();
		}
		@Override
		public Getter reqGetCurrentLimitSetting() {
			return (Getter)super.reqGetCurrentLimitSetting();
		}
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetFaultDescription() {
			return (Getter)super.reqGetFaultDescription();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetBusinessFacilityCode() {
			return (Getter)super.reqGetBusinessFacilityCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetProductionNumber() {
			return (Getter)super.reqGetProductionNumber();
		}
		@Override
		public Getter reqGetProductionDate() {
			return (Getter)super.reqGetProductionDate();
		}
		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			return (Getter)super.reqGetPowerSavingOperationSetting();
		}
		@Override
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
		}
		@Override
		public Getter reqGetCurrentTimeSetting() {
			return (Getter)super.reqGetCurrentTimeSetting();
		}
		@Override
		public Getter reqGetCurrentDateSetting() {
			return (Getter)super.reqGetCurrentDateSetting();
		}
		@Override
		public Getter reqGetPowerLimitSetting() {
			return (Getter)super.reqGetPowerLimitSetting();
		}
		@Override
		public Getter reqGetCumulativeOperatingTime() {
			return (Getter)super.reqGetCumulativeOperatingTime();
		}
		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			return (Getter)super.reqGetStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Getter reqGetSetPropertyMap() {
			return (Getter)super.reqGetSetPropertyMap();
		}
		@Override
		public Getter reqGetGetPropertyMap() {
			return (Getter)super.reqGetGetPropertyMap();
		}
		
		/**
		 * Property name : Detection threshold level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies detection threshold level (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDetectionThresholdLevel() {
			reqGetProperty(EPC_DETECTION_THRESHOLD_LEVEL);
			return this;
		}
		/**
		 * Property name : Micromotion detection status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether micromotion is detected or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Micromotion detected = 0x41 Micromotion not detected = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMicromotionDetectionStatus() {
			reqGetProperty(EPC_MICROMOTION_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Detection counter<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDetectionCounter() {
			reqGetProperty(EPC_DETECTION_COUNTER);
			return this;
		}
		/**
		 * Property name : Sampling count<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSamplingCount() {
			reqGetProperty(EPC_SAMPLING_COUNT);
			return this;
		}
		/**
		 * Property name : Sampling cycle<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : msec<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSamplingCycle() {
			reqGetProperty(EPC_SAMPLING_CYCLE);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
				@Override
		public Informer reqInformOperationStatus() {
			return (Informer)super.reqInformOperationStatus();
		}
		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}
		@Override
		public Informer reqInformStandardVersionInformation() {
			return (Informer)super.reqInformStandardVersionInformation();
		}
		@Override
		public Informer reqInformIdentificationNumber() {
			return (Informer)super.reqInformIdentificationNumber();
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			return (Informer)super.reqInformMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			return (Informer)super.reqInformMeasuredCumulativePowerConsumption();
		}
		@Override
		public Informer reqInformManufacturersFaultCode() {
			return (Informer)super.reqInformManufacturersFaultCode();
		}
		@Override
		public Informer reqInformCurrentLimitSetting() {
			return (Informer)super.reqInformCurrentLimitSetting();
		}
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformFaultDescription() {
			return (Informer)super.reqInformFaultDescription();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformBusinessFacilityCode() {
			return (Informer)super.reqInformBusinessFacilityCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformProductionNumber() {
			return (Informer)super.reqInformProductionNumber();
		}
		@Override
		public Informer reqInformProductionDate() {
			return (Informer)super.reqInformProductionDate();
		}
		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			return (Informer)super.reqInformPowerSavingOperationSetting();
		}
		@Override
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
		}
		@Override
		public Informer reqInformCurrentTimeSetting() {
			return (Informer)super.reqInformCurrentTimeSetting();
		}
		@Override
		public Informer reqInformCurrentDateSetting() {
			return (Informer)super.reqInformCurrentDateSetting();
		}
		@Override
		public Informer reqInformPowerLimitSetting() {
			return (Informer)super.reqInformPowerLimitSetting();
		}
		@Override
		public Informer reqInformCumulativeOperatingTime() {
			return (Informer)super.reqInformCumulativeOperatingTime();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}
		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}
		
		/**
		 * Property name : Detection threshold level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies detection threshold level (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDetectionThresholdLevel() {
			reqInformProperty(EPC_DETECTION_THRESHOLD_LEVEL);
			return this;
		}
		/**
		 * Property name : Micromotion detection status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether micromotion is detected or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Micromotion detected = 0x41 Micromotion not detected = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMicromotionDetectionStatus() {
			reqInformProperty(EPC_MICROMOTION_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Detection counter<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDetectionCounter() {
			reqInformProperty(EPC_DETECTION_COUNTER);
			return this;
		}
		/**
		 * Property name : Sampling count<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling count.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSamplingCount() {
			reqInformProperty(EPC_SAMPLING_COUNT);
			return this;
		}
		/**
		 * Property name : Sampling cycle<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates micromotion detection sampling cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFE (0.65534)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : msec<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSamplingCycle() {
			reqInformProperty(EPC_SAMPLING_CYCLE);
			return this;
		}
	}

	public static class Proxy extends MicromotionSensor {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
		@Override
		protected byte[] getMicromotionDetectionStatus() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
