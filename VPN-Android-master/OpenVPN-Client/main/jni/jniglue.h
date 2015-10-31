

#ifndef xcopenvpn_jniglue_h
#define xcopenvpn_jniglue_h
void android_openvpn_log(int level,const char* prefix,const char* prefix_sep,const char* m1);
#endif

#ifdef __cplusplus
extern "C" {
#endif
    int jniThrowException(JNIEnv* env, const char* className, const char* msg);

#ifdef __cplusplus
}
#endif
