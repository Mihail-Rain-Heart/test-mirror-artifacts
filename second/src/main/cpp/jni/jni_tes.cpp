#include <jni.h>
#include "../core/tes.h"

static void native_log_message(
        JNIEnv *env,
        jobject clazz
) {
    tes();
}

static JNINativeMethod methods[] = {
        {
                "tes",
                "()V",
                reinterpret_cast<void*>(native_log_message)
        }
};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *) {
    JNIEnv *env;
    vm->GetEnv((void **) &env, JNI_VERSION_1_6);

    jclass clazz = env->FindClass("ru/testmirrorartifacts/second/Tes");
    env->RegisterNatives(clazz, methods, 1);

    return JNI_VERSION_1_6;
}
