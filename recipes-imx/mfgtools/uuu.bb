LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

SRCREV = "uuu_1.4.165"
SRC_URI = "git://github.com/NXPmicro/mfgtools.git;protocol=https"
S = "${WORKDIR}/git"

DEPENDS += "bzip2 libusb-compat libusb1 libzip openssl"
