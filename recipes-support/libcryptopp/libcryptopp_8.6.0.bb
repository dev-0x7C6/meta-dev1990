SUMMARY = "A free C++ class library of cryptographic schemes"
HOMEPAGE = "http://www.cryptopp.com/wiki/Main_Page"
BUGTRACKER = "http://sourceforge.net/apps/trac/cryptopp/"
SECTION = "libs"

LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://License.txt;md5=15f12037d9859d059c3a557798163450"

BBCLASSEXTEND = "native nativesdk"

PR = "r3"

SRC_URI = "git://github.com/weidai11/cryptopp.git;protocol=https;branch=master"
SRCREV = "69bf6b53052b59ccb57ce068ce741988ae087317"
S = "${WORKDIR}/git"

LIBVER = "8.6.0"

inherit autotools-brokensep pkgconfig

PACKAGES:prepend = "${PN}-test "
FILES:${PN}-test = "${bindir} ${datadir}/cryptopp"
EXTRA_OECONF = "--libdir=${base_libdir}"
TARGET_CC_ARCH += "${LDFLAGS}"
export PREFIX="${prefix}"

EXTRA_OEMAKE:class-native = "CC='${CC}' CXX='${CXX}'"

do_compile() {
    sed -i -e 's/^CXXFLAGS/#CXXFLAGS/' GNUmakefile
    export CXXFLAGS="${CXXFLAGS} -DNDEBUG -fPIC"
    oe_runmake all libcryptopp.so
}

# do not provide the shared object file, so we force to link statically for host tools
do_compile:class-native() {
    sed -i -e 's/^CXXFLAGS/#CXXFLAGS/' GNUmakefile
    export CXXFLAGS="${CXXFLAGS} -DNDEBUG -fPIC"
    oe_runmake all
}

do_install:append() {
    install -d ${D}${libdir}
    ln -sf libcryptopp.so.${LIBVER} ${D}${libdir}/libcryptopp.so.8
    ln -sf libcryptopp.so.${LIBVER} ${D}${libdir}/libcryptopp.so.8.6
}
