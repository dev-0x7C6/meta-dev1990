LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

TOOLCHAIN = "clang"
CXXBENCH_DEFAULT_FLAGS = "-std=c++14 -O2"

inherit clang cxxscore