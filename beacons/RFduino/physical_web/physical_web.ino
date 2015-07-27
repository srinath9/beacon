// Physical-Web example for RFDigital RFduino

#include <RFduinoBLE.h>

uint8_t advdata[] =
{
  0x03,  // length
  0x03,  // Param: Service List
  0xD8, 0xFE,  // URI Beacon ID
  0x0A,  // length
  0x16,  // Service Data
  0xD8, 0xFE, // URI Beacon ID
  0x00,  // flags
  0xEE,  // power
  0x00,  // http://www.
  'A',
  'B',
  'C',
  0x00,  // .".com"
};

void setup() {
  RFduinoBLE_advdata = advdata;
  RFduinoBLE_advdata_len = sizeof(advdata);
  RFduinoBLE.advertisementInterval = 1000; // advertise every 1000ms
  RFduinoBLE.connectable = false;
  RFduinoBLE.begin();
}

void loop() {
  RFduino_ULPDelay(INFINITE);   // switch to lower power mode
}
