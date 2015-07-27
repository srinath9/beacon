/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uribeacon.validator;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import org.uribeacon.beacon.ConfigUriBeacon;
import org.uribeacon.config.ProtocolV2;
import org.uribeacon.validator.TestHelper.Builder;
import org.uribeacon.validator.TestHelper.TestCallback;

import java.util.ArrayList;

class SpecUriBeaconTests {

  public static final String TEST_NAME = "Spec UriBeacon Tests";

  public static ArrayList<TestHelper> initializeTests(Context context, TestCallback testCallback,
      boolean optional) {
    ArrayList<Builder> specUriBeaconTestsBuilder = new ArrayList<>();
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Connecting...")
            .connect()
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long UriData")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.DATA, TestData.LONG_URI, BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Short Flags")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.FLAGS, TestData.SHORT_FLAGS,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long Flags")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.FLAGS, TestData.LONG_FLAGS,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Short Advertised Tx Power Levels")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.POWER_LEVELS, TestData.SHORT_TX_POWER_LEVELS,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long Advertised Tx Power Levels")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.POWER_LEVELS, TestData.LONG_TX_POWER_LEVELS,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );

    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Short Power Mode")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.POWER_MODE, TestData.SHORT_POWER_MODE,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long Power Mode")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.POWER_MODE, TestData.LONG_POWER_MODE,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Invalid Power Mode")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#37-tx-power-mode")
            .write(ProtocolV2.POWER_MODE, TestData.INVALID_POWER_MODE, BluetoothGatt.GATT_WRITE_NOT_PERMITTED)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Short Period")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.PERIOD, TestData.SHORT_PERIOD,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long Period")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.PERIOD, TestData.LONG_PERIOD,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Short Reset")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.RESET, TestData.SHORT_RESET,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Try Long Reset")
            .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
            .write(ProtocolV2.RESET, TestData.LONG_RESET,
                BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
    );
    if (optional) {
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Try Lock with Short Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
              .write(ProtocolV2.LOCK, TestData.SHORT_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Try Lock with Long Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
              .write(ProtocolV2.LOCK, TestData.LONG_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locking beacon...")
              .write(ProtocolV2.LOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.LOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Lock with Short Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.LOCK, TestData.SHORT_LOCK_KEY,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Lock with Valid Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.LOCK, TestData.BASIC_LOCK_KEY,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Lock with Long Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.LOCK, TestData.LONG_LOCK_KEY,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Unlocking beacon...")
              .write(ProtocolV2.UNLOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.UNLOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Try Unlock with Short Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
              .write(ProtocolV2.UNLOCK, TestData.SHORT_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Try Unlock with Valid Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#33-unlock")
              .write(ProtocolV2.UNLOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Try Unlock with Long Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#13-return-codes")
              .write(ProtocolV2.UNLOCK, TestData.LONG_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locking beacon...")
              .write(ProtocolV2.LOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.LOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try to Unlock with Short Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#33-unlock")
              .write(ProtocolV2.UNLOCK, TestData.SHORT_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.LOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Unlock with Long Key")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#33-unlock")
              .write(ProtocolV2.UNLOCK, TestData.LONG_LOCK_KEY,
                  BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.LOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Unlocking...")
              .write(ProtocolV2.UNLOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.UNLOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locking...")
              .write(ProtocolV2.LOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
              .assertEquals(ProtocolV2.LOCK_STATE, TestData.LOCKED_STATE,
                  BluetoothGatt.GATT_SUCCESS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Data")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.DATA, TestData.LONG_URI, TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Short Flags")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.FLAGS, TestData.SHORT_FLAGS,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Valid Flags")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.FLAGS, TestData.BASIC_GENERAL_DATA,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Flags")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.FLAGS, TestData.LONG_FLAGS,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Short Advertised Tx Power Levels")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_LEVELS, TestData.SHORT_TX_POWER_LEVELS,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Valid Advertised Tx Power Levels")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_LEVELS, TestData.BASIC_TX_POWER_LEVELS,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Advertised Tx Power Levels")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_LEVELS, TestData.LONG_TX_POWER_LEVELS,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Short Power Mode")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_MODE, TestData.SHORT_POWER_MODE,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Valid Power Mode")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_MODE, TestData.BASIC_GENERAL_DATA,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Invalid Power Mode")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_MODE, TestData.INVALID_POWER_MODE, ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Power Mode")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.POWER_MODE, TestData.BASIC_GENERAL_DATA,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Short Period")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.PERIOD, TestData.SHORT_PERIOD,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Valid Period")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.PERIOD, TestData.BASIC_PERIOD,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Period")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.PERIOD, TestData.LONG_PERIOD,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Short Reset")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.RESET, TestData.SHORT_RESET,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Valid Reset")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.RESET, TestData.BASIC_GENERAL_DATA,
                  ConfigUriBeacon.INSUFFICIENT_AUTHORIZATION)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Locked: Try Long Reset")
              .reference("https://github.com/google/uribeacon/blob/master/specification/ConfigService.md#32-lock")
              .write(ProtocolV2.RESET, TestData.LONG_RESET,
                  TestData.VALID_LENGTH_AUTHORIZATION_ERRORS)
      );
      specUriBeaconTestsBuilder.add(
          new Builder()
              .name("Unlocking...")
              .write(ProtocolV2.UNLOCK, TestData.BASIC_LOCK_KEY, BluetoothGatt.GATT_SUCCESS)
      );
    }
    specUriBeaconTestsBuilder.add(
        new Builder()
            .name("Disconnecting...")
            .disconnect()
    );
    ArrayList<TestHelper> specUriBeaconTests = new ArrayList<>();
    for (Builder builder : specUriBeaconTestsBuilder) {
      specUriBeaconTests.add(builder
          .setUp(context, ProtocolV2.CONFIG_SERVICE_UUID, testCallback)
          .build());
    }
    return specUriBeaconTests;
  }
}
