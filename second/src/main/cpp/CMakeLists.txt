cmake_minimum_required(VERSION 3.22.1)

project("tes")

add_library(
        tes
        SHARED
        jni/jni_tes.cpp
        core/tes.cpp
)

find_library(log-lib log)

find_library(jnigraphics-lib jnigraphics)

# uncomment to disable asserts
#target_compile_definitions(stackblur PRIVATE NO_ASSERT)

target_include_directories(
        tes
        PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/core
)

target_link_libraries(
        tes
        ${log-lib}
        ${jnigraphics-lib}
)

target_compile_options(tes PRIVATE -O3)
