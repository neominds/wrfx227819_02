#
# Copyright (C) 2015 Wind River Systems, Inc.
#

TARGET_SUPPORTED_KTYPES = "standard preempt-rt"

#KERNEL_EXTRA_ARGS += "LOADADDR=0x8000"
#KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/mb86s72eb.dtb"
KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/mb86s72eb.dts"
