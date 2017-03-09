require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb \
                    file://README;beginline=1;endline=22;md5=78b195c11cb6ef63e6985140db7d7bab"

SRC_URI = "git://github.com/Xilinx/u-boot-xlnx.git"

# This revision corresponds to the tag "xilinx-v14.7"
SRCREV = "4cb9c3de73d66372d40d24baf82fa87a702f0c9b"

PV = "xilinx-v14.7+git${SRCPV}"
PR = "r0"

S = "${WORKDIR}/git"

UBOOT_ELF ?= "u-boot.elf"
UBOOT_ELF_LONG ?= "u-boot-${MACHINE}-${PV}-${PR}.elf"
UBOOT_ELF_SYMLINK ?= "u-boot-${MACHINE}.elf"

do_deploy_append() {
	# Also deploy the ELF file
	install -d ${DEPLOYDIR}
	install ${S}/u-boot ${DEPLOYDIR}/${UBOOT_ELF_LONG}

	cd ${DEPLOYDIR}
	rm -f ${UBOOT_ELF} ${UBOOT_ELF_SYMLINK}
	ln -sf ${UBOOT_ELF_LONG} ${UBOOT_ELF}
	ln -sf ${UBOOT_ELF_LONG} ${UBOOT_ELF_SYMLINK}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN}-dbg += "${libdir}/u-boot/.debug"
FILES_${PN}-dev += "${libdir}/u-boot"
