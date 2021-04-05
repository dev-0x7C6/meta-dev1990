LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

SRCREV = "v${PV}"
SRC_URI = "gitsm://github.com/dev-0x7C6/tokei-frame.git;protocol=https;user=git;branch=main"
S = "${WORKDIR}/git"

DEPENDS = "qtbase qtquickcontrols2"
