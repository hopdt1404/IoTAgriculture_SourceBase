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
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class WashingMachine extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03C5;

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_WASHING_MACHINE_SETTING = (byte)0xB2;
	public static final byte EPC_CURRENT_STAGE_OF_WASHING_CYCLE = (byte)0xE1;
	public static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE = (byte)0xE6;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING = (byte)0x92;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewWashingMachine(this);
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the door/cover is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the door/cover is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidDoorCoverOpenCloseStatus(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : Washing machine setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Washing machine setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart the washing cycle (started/restarted) = 0x41<br>
	 * Suspend the washing cycle (suspended) = 0x42<br>
	 * Stop the washing cycle (stopped) = 0x43<br>
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
	protected boolean setWashingMachineSetting(byte[] edt) {return false;}
	/**
	 * Property name : Washing machine setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Washing machine setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart the washing cycle (started/restarted) = 0x41<br>
	 * Suspend the washing cycle (suspended) = 0x42<br>
	 * Stop the washing cycle (stopped) = 0x43<br>
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
	protected byte[] getWashingMachineSetting() {return null;}
	/**
	 * Property name : Washing machine setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Washing machine setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart the washing cycle (started/restarted) = 0x41<br>
	 * Suspend the washing cycle (suspended) = 0x42<br>
	 * Stop the washing cycle (stopped) = 0x43<br>
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
	protected boolean isValidWashingMachineSetting(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : Current stage of washing cycle<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current stage of the washing cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getCurrentStageOfWashingCycle() {return null;}
	/**
	 * Property name : Current stage of washing cycle<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current stage of the washing cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidCurrentStageOfWashingCycle(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : Time remaining to complete washing cycle<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B  (= 0.23): (= 0.59): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getTimeRemainingToCompleteWashingCycle() {return null;}
	/**
	 * Property name : Time remaining to complete washing cycle<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B  (= 0.23): (= 0.59): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTimeRemainingToCompleteWashingCycle(byte[] edt) {
		return edt != null && edt.length == 3;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		return edt != null && edt.length == 1;
	}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected boolean isValidOnTimerSetting(byte[] edt) {
		return edt != null && edt.length == 2;
	}
	/**
	 * Property name : Relative
time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative
time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	/**
	 * Property name : Relative
time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
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
	protected boolean isValidRelativeTimeBasedOnTimerSetting(byte[] edt) {
		return edt != null && edt.length == 2;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_WASHING_MACHINE_SETTING : return setWashingMachineSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return setRelativeTimeBasedOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return getDoorCoverOpenCloseStatus();
		case EPC_WASHING_MACHINE_SETTING : return getWashingMachineSetting();
		case EPC_CURRENT_STAGE_OF_WASHING_CYCLE : return getCurrentStageOfWashingCycle();
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE : return getTimeRemainingToCompleteWashingCycle();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return getRelativeTimeBasedOnTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return isValidDoorCoverOpenCloseStatus(property.edt);
		case EPC_WASHING_MACHINE_SETTING : return isValidWashingMachineSetting(property.edt);
		case EPC_CURRENT_STAGE_OF_WASHING_CYCLE : return isValidCurrentStageOfWashingCycle(property.edt);
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE : return isValidTimeRemainingToCompleteWashingCycle(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return isValidRelativeTimeBasedOnTimerSetting(property.edt);
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
			case EPC_WASHING_MACHINE_SETTING : 
				onSetWashingMachineSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : 
				onGetDoorCoverOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHING_MACHINE_SETTING : 
				onGetWashingMachineSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_STAGE_OF_WASHING_CYCLE : 
				onGetCurrentStageOfWashingCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE : 
				onGetTimeRemainingToCompleteWashingCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the door/cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
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
		 * Get - optional<br>
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing machine setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Washing machine setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart the washing cycle (started/restarted) = 0x41<br>
		 * Suspend the washing cycle (suspended) = 0x42<br>
		 * Stop the washing cycle (stopped) = 0x43<br>
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
		protected void onSetWashingMachineSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing machine setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Washing machine setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart the washing cycle (started/restarted) = 0x41<br>
		 * Suspend the washing cycle (suspended) = 0x42<br>
		 * Stop the washing cycle (stopped) = 0x43<br>
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
		protected void onGetWashingMachineSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current stage of washing cycle<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current stage of the washing cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br>
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
		 * Get - optional<br>
		 */
		protected void onGetCurrentStageOfWashingCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time remaining to complete washing cycle<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B  (= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTimeRemainingToCompleteWashingCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative
time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative
time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Washing machine setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Washing machine setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart the washing cycle (started/restarted) = 0x41<br>
		 * Suspend the washing cycle (suspended) = 0x42<br>
		 * Stop the washing cycle (stopped) = 0x43<br>
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
		public Setter reqSetWashingMachineSetting(byte[] edt) {
			reqSetProperty(EPC_WASHING_MACHINE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Relative
time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the door/cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetDoorCoverOpenCloseStatus() {
			reqGetProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washing machine setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Washing machine setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart the washing cycle (started/restarted) = 0x41<br>
		 * Suspend the washing cycle (suspended) = 0x42<br>
		 * Stop the washing cycle (stopped) = 0x43<br>
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
		public Getter reqGetWashingMachineSetting() {
			reqGetProperty(EPC_WASHING_MACHINE_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washing cycle<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current stage of the washing cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetCurrentStageOfWashingCycle() {
			reqGetProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washing cycle<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B  (= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTimeRemainingToCompleteWashingCycle() {
			reqGetProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
		public Getter reqGetOnTimerReservationSetting() {
			reqGetProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Getter reqGetOnTimerSetting() {
			reqGetProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative
time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			reqGetProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the door/cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformDoorCoverOpenCloseStatus() {
			reqInformProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washing machine setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Washing machine setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart the washing cycle (started/restarted) = 0x41<br>
		 * Suspend the washing cycle (suspended) = 0x42<br>
		 * Stop the washing cycle (stopped) = 0x43<br>
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
		public Informer reqInformWashingMachineSetting() {
			reqInformProperty(EPC_WASHING_MACHINE_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washing cycle<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current stage of the washing cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformCurrentStageOfWashingCycle() {
			reqInformProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washing cycle<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B  (= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTimeRemainingToCompleteWashingCycle() {
			reqInformProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
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
		public Informer reqInformOnTimerReservationSetting() {
			reqInformProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Informer reqInformOnTimerSetting() {
			reqInformProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative
time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
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
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			reqInformProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends WashingMachine {
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
