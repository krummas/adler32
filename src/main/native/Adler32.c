#include <jni.h>
#include <stdio.h>
#include "org_drizzle_adler_Adler32.h"
#include <zlib.h>

JNIEXPORT void JNICALL Java_org_drizzle_adler_Adler32_checksum(JNIEnv * env, jobject self, jobject buffer, jint pos, jint len, jobject checksum) {
  char* b = (*env)->GetDirectBufferAddress(env, buffer);
  char* c = (*env)->GetDirectBufferAddress(env, checksum);
  long csum = adler32(1L, b+pos, len);
  c[3] = (char)(csum&0xff);
  c[2] = (char)((csum >> 8)&0xff);
  c[1] = (char)((csum >> 16)&0xff);
  c[0] = (char)((csum >> 24)&0xff);
}
