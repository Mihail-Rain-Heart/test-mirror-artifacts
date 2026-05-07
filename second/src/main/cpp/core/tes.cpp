#include <android/log.h>

#define LOG_TAG "TAG21"

void tes() {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Hello from C++");
}
