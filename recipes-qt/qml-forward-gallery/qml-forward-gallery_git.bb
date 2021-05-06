SUMMARY = "Simple slideshow gallery application written in Qt/Qml"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

SRCREV = "v0.2.0"
SRC_URI = "gitsm://github.com/dev-0x7C6/${BPN}.git;protocol=https;user=git;branch=main"
S = "${WORKDIR}/git"

PACKAGECONFIG ?= "quickcompiler"

PACKAGECONFIG[quickcompiler] = "-DENABLE_QT_QUICK_COMPILER=ON,-DENABLE_QT_QUICK_COMPILER=OFF,qtdeclarative-native"

DEPENDS = "qtbase qtquickcontrols2"
RDEPENDS_${PN} += "qtquickcontrols2"
