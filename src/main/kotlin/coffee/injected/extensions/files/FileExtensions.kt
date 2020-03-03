package coffee.injected.extensions.files

import java.io.File

inline val File.size: Long get() = length()