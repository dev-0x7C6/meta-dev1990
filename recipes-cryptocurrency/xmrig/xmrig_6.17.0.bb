SUMMARY = "RandomX, CryptoNight and Argon2 CPU miner"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "libuv openssl hwloc"

SRC_URI = " \
  git://github.com/xmrig/xmrig.git;protocol=https;branch=master \
  file://0001-Recognize-armv7ve-as-valid-ARMv7-target.patch \
"
SRCREV = "56c95703a555e8bdf773b51ea475be9ad58c4333"

S = "${WORKDIR}/git"
PR = "r3"

inherit cmake pkgconfig

RDEPENDS:${PN} += "bash"

ARM_TYPE:armv7a = "armv7a"
ARM_TYPE:armv7ve = "armv7ve"

def map_host_arch_to_uname_arch(host_arch):
    if host_arch == "arm":
        return "${ARM_TYPE}"
    if host_arch == "powerpc":
        return "ppc"
    if host_arch == "powerpc64le":
        return "ppc64le"
    if host_arch == "powerpc64":
        return "ppc64"
    return host_arch


do_configure:prepend() {
    # Set minimal and default donate level to 0
    sed -i 's/1;/0;/g' ${S}/src/donate.h
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/xmrig ${D}${bindir}
    install -m 755 ${S}/scripts/enable_1gb_pages.sh ${D}${bindir}
    install -m 755 ${S}/scripts/randomx_boost.sh ${D}${bindir}
}

INSANE_SKIP:${PN} = "already-stripped"