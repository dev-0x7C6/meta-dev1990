LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ffc7b92dd29b8fa1515b8492c86c778"

inherit cmake

SRCREV = "5161918174fb2cc572535594cba95c617d2b2a40"
SRC_URI = "gitsm://github.com/dev-0x7C6/cryptographic-hash-benchmark.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

DEPENDS = "google-benchmark libcryptopp openssl"