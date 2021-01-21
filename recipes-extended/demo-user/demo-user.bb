SUMMARY = "Demo user account"
DESCRIPTION = "Dedicated user account for demo propose"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit useradd systemd

RDEPENDS_${PN} += "bash"

DEMO_USER_GROUPS ?= "video,audio,users,tty,root,dialout,input,disk"
DEMO_USER_ID ?= "1000"
DEMO_USER_NAME ?= "demo"
DEMO_USER_PASSWORD ?= "${DEMO_USER_NAME}"
DEMO_USER_HOMEDIR ?= "/home/${DEMO_USER_NAME}"


USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
  --create-home \
  --user-group \
  --groups ${DEMO_USER_GROUPS} \
  --uid ${DEMO_USER_ID} \
  --home ${DEMO_USER_HOMEDIR} \
  --shell /bin/bash \
  -P ${DEMO_USER_PASSWORD} \
  ${DEMO_USER_NAME} \
"

ALLOW_EMPTY_${PN} = "1"
EXCLUDE_FROM_WORLD = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
