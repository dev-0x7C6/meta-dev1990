LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

SRC_URI = "git://github.com/NXPmicro/mfgtools.git;protocol=https"
SRCREV = "e56424c825752cbc23a34fc685d9d958adc30e62"
S = "${WORKDIR}/git"

DEPENDS += "bzip2 libusb-compat libusb1 libzip openssl"
