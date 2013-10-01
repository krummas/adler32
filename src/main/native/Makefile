#!/usr/bin/make -f

OUTFILE := ../../../target/classes/org/drizzle/adler/libadler32.so
JDK_DIR := /usr/lib/jvm/jdk-7.25-oracle-x64
CPPFLAGS := -I$(JDK_DIR)/include -I$(JDK_DIR)/include/linux -lz -o $(OUTFILE) -fPIC -shared -Wl,-soname,adler32.so -std=gnu99
JAVAH := $(JDK_DIR)/bin/javah

all:
	$(JAVAH) -cp ../java/ org.drizzle.adler.Adler32
	gcc $(CPPFLAGS) Adler32.c
