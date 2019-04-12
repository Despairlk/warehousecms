package com.fenger.sys.contast;

public interface SysConstast {

    /**
     * PERMISSION 可用
     */
    Integer AVAILABLE_TRUE = 1;
    Integer AVAILABLE_FALSE = 0;

    /**
     * PERMISSION 类型
     */
    String TYPE_PERMISSION_MENU = "menu";
    String TYPE_PERMISSION_PERMISSION = "permission";
    Integer USER_SUPER = 0;
    Integer USER_NORMAL = 1;

    Integer STATUS_OPEN_TRUE = 1;
    Integer STATUS_OPEN_FALSE = 0;

    Integer SUCCESS_CODE = 0;
    Integer ERROR_CODE = 1;

    String SUCCESS_MSG = "操作成功";
    String ERROR_MSG = "操作失败";
    String ADD_SUCCESS_MSG = "添加成功";
    String ADD_ERROR_MSG = "添加失败";
    String UPDATE_SUCCESS_MSG = "修改成功";
    String UPDATE_ERROR_MSG = "修改失败";
    String DELETE_SUCCESS_MSG = "删除成功";
    String DELETE_ERROR_MSG = "删除失败";
}
