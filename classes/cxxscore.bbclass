LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/dev-0x7C6/cxxscore.git;protocol=https;branch=master;user=git"

S = "${WORKDIR}/git"

CXXBENCH_SYSTEM_TUNE_FLAGS ?= ""
CXXBENCH_DEFAULT_FLAGS ?= "-std=c++14 -O2"

EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release"
EXTRA_OECMAKE += " -DCXXBENCH_BINARY_NAME='${PN}'"
EXTRA_OECMAKE += " -DCMAKE_CXX_FLAGS_RELEASE='${CXXBENCH_SYSTEM_TUNE_FLAGS} ${CXXBENCH_DEFAULT_FLAGS} -DNDEBUG'"

inherit cmake