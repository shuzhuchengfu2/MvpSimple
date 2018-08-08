package barray.base.mvp.utils;

import android.util.Log;

/**
 * 日志工具类
 */

public class LogUtil {
    private static int level;
    private static final String TAG = "LogUtil";
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_WARN = 4;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_NONE = 6;

    public static void setLogLevel(int level) {
        LogUtil.level = level;
    }

    //////////////////////////  v  ////////////////////////////////////

    public static void v(String tag, String log) {
        if (level <= LEVEL_VERBOSE) {
            if (log != null) {
                if (tag == null) {
                    Log.v(TAG, log);
                } else {
                    Log.v(tag, log);
                }
            }
        }
    }

    public static void v(String tag, String log, Throwable t) {
        if (level <= LEVEL_VERBOSE) {
            if (log != null) {
                if (tag == null) {
                    Log.v(TAG, log, t);
                } else {
                    Log.v(tag, log, t);
                }
            }
        }
    }


    public static void v(String log) {
        v(null, log);
    }

    public static void v(String log, Throwable t) {
        v(null, log, t);
    }

    //////////////////////////  d  ////////////////////////////////////

    public static void d(String tag, String log) {
        if (level <= LEVEL_DEBUG) {
            if (log != null) {
                if (tag == null) {
                    Log.d(TAG, log);
                } else {
                    Log.d(tag, log);
                }
            }
        }
    }

    public static void d(String tag, String log, Throwable t) {
        if (level <= LEVEL_DEBUG) {
            if (log != null) {
                if (tag == null) {
                    Log.d(TAG, log, t);
                } else {
                    Log.d(tag, log, t);
                }
            }
        }
    }


    public static void d(String log) {
        d(null, log);
    }

    public static void d(String log, Throwable t) {
        d(null, log, t);
    }

    //////////////////////////  i  ////////////////////////////////////

    public static void i(String tag, String log) {
        if (level <= LEVEL_INFO) {
            if (log != null) {
                if (tag == null) {
                    Log.i(TAG, log);
                } else {
                    Log.i(tag, log);
                }
            }
        }
    }

    public static void i(String tag, String log, Throwable t) {
        if (level <= LEVEL_INFO) {
            if (log != null) {
                if (tag == null) {
                    Log.i(TAG, log, t);
                } else {
                    Log.i(tag, log, t);
                }
            }
        }
    }


    public static void i(String log) {
        i(null, log);
    }

    public static void i(String log, Throwable t) {
        i(null, log, t);
    }

    //////////////////////////  w  ////////////////////////////////////

    public static void w(String tag, String log) {
        if (level <= LEVEL_WARN) {
            if (log != null) {
                if (tag == null) {
                    Log.w(TAG, log);
                } else {
                    Log.w(tag, log);
                }
            }
        }
    }

    public static void w(String tag, String log, Throwable t) {
        if (level <= LEVEL_WARN) {
            if (log != null) {
                if (tag == null) {
                    Log.w(TAG, log, t);
                } else {
                    Log.w(tag, log, t);
                }
            }
        }
    }


    public static void w(String log) {
        w(null, log);
    }

    public static void w(String log, Throwable t) {
        w(null, log, t);
    }

    //////////////////////////  e  ////////////////////////////////////

    public static void e(String tag, String log) {
        if (level <= LEVEL_ERROR) {
            if (log != null) {
                if (tag == null) {
                    Log.e(TAG, log);
                } else {
                    Log.e(tag, log);
                }
            }
        }
    }

    public static void e(String tag, String log, Throwable t) {
        if (level <= LEVEL_ERROR) {
            if (log != null) {
                if (tag == null) {
                    Log.e(TAG, log, t);
                } else {
                    Log.e(tag, log, t);
                }
            }
        }
    }


    public static void e(String log) {
        e(null, log);
    }

    public static void e(String log, Throwable t) {
        e(null, log, t);
    }


}
