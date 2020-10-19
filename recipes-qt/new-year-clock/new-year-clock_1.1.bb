DESCRIPTION = "Qml clock for new year celebration."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

SRCREV = "v${PV}"
SRC_URI = "gitsm://github.com/dev-0x7C6/new-year-clock.git;protocol=https;branch=master;user=git"

S = "${WORKDIR}/git"

DEPENDS += "qtbase qtmultimedia qtdeclarative"
