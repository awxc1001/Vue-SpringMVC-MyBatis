<template>
    <div>

        <!--search and add new button-->
        <div style="margin: 15px 5px">
            <el-button type="primary" @click="add">add new</el-button>
            <el-button>Others</el-button>
        </div>

        <div style="margin: 10px 5px">
            <el-input v-model="search" style="width: 30%;" placeholder="type keyword to search"/>
            <el-button style="margin-left: 10px" type="primary" @click="list">search</el-button>
        </div>


        <el-table :data="tableData" stripe style="width: 90%">
            <el-table-column
                    prop="id"
                    label="ID"
                    sortable
            >
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="NAME"
            >
            </el-table-column>
            <el-table-column
                    prop="maker"
                    label="MAKER">
            </el-table-column>
            <el-table-column
                    prop="price"
                    label="PRICE">
            </el-table-column>
            <el-table-column
                    prop="sales"
                    label="SALES">
            </el-table-column>
            <el-table-column
                    prop="stock"
                    label="STOCK">
            </el-table-column>
            <el-table-column fixed="right" width="150"
                             prop="action"
                             label="ACTION">
                <template #default="scope">
                    <el-button type="text" @click="handleEdit(scope.row)">EDIT</el-button>
                    <!--
                        点击的确定，就会触发handleDel
                       点击的是取消，就不会触发handleDel
                    -->
                    <el-popconfirm title="confirm delete?" @confirm="handleDel(scope.row.id)">
                        <template #reference>
                            <el-button size="small" type="danger">DEL</el-button>
                        </template>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <!-- 添加家居的弹窗
      说明:
      1. el-dialog ：v-model="dialogVisible" 表示对话框, 和dialogVisible 变量双向绑定,控制是否显示对话框
      2. el-form :model="form" 表示表单 ,数据和 form数据变量双向绑定
      3. el-input v-model="form.name" 表示表单的input控件，名字为name 需要和后台Javabean[Furn] 属性一致
      4. 在前端中, 对象的属性是可以动态生成的
    -->
        <el-dialog title="Add New Info" v-model="dialogVisible" width="30%">
            <el-form :model="form" label-width="120px">
                <el-form-item label="name">
                    <el-input v-model="form.name" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="maker">
                    <el-input v-model="form.maker" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="price">
                    <el-input v-model="form.price" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="sales">
                    <el-input v-model="form.sales" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="stock">
                    <el-input v-model="form.stock" style="width: 80%"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
        <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save">Confirm</el-button>
        </span>
            </template>
        </el-dialog>

        <div style="margin: 10px 0">
            <el-pagination
                    @size-change="handlePageSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[2,5,10,15]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

    </div>
</template>
<script>
    // @ is an alias to /src
    import request from "@/utils/request";

    export default {
        name: 'HomeView',
        components: {},
        data() {
            return {
                // 增加分页相应的数据绑定
                currentPage: 1, //当前页
                pageSize: 5,//每页显示记录数
                total: 10,//共有多少记录
                search: "",
                dialogVisible: false,
                form: {},
                tableData: []
            }
        },
        created() {
            this.list();//use list function()
        },
        methods: {
            add() {
                this.dialogVisible = true
                //clear form after cancel or submit
                this.form = {}
            },
            save() {
                //update and addNew all use the same form, if update will have id as data
                if (this.form.id) {
                    request.put("api/update", this.form).then(response => {
                        if (response.code == 200) {
                            //show success message box
                            this.$message(
                                {
                                    type: "success",
                                    message: "update successful!"
                                }
                            )
                        } else {
                            //show fail message box
                            this.$message(
                                {
                                    type: "error",
                                    message: "update failed!"
                                }
                            )
                        }
                        //close dialog and update data
                        this.dialogVisible = false
                        this.list()
                    })
                } else {
                    request.post("/api/save", this.form).then(response => {
                        console.log(response)
                        this.dialogVisible = false
                        //refresh list after adding new
                        this.list()
                    })
                }
            },
            list() {
                request.get("api/furnsBySearchPage", {
                    params: {//request param
                        pageNum: this.currentPage,
                        pageSize: this.pageSize,
                        search: this.search
                    }
                }).then(res => {//page info return
                    this.tableData = res.extend.pageInfo.list
                    this.total = res.extend.pageInfo.total
                })
            },
            handleEdit(row) {
                //make sure url is correct
                request.delete("/api/find/" + row.id).then(res => {
                    this.form = res.extend.furn
                })
            },
            handleDel(id) {
                console.log(id)
                //make sure url is correct
                request.delete("/api/del/" + id).then(res => {
                    if (res.code === 200) {
                        this.$message(
                            {
                                type: "success",
                                message: res.msg
                            }
                        )
                    } else {
                        this.$message(
                            {
                                type: "error",
                                message: res.msg
                            }
                        )
                    }
                    //refresh list
                    this.list()
                })
            },
            handleCurrentChange(pageNum) { //处理分页请求
                //当用户点击分页超链接时，会携带pageNum
                //console.log("pageNum-" + pageNum)
                this.currentPage = pageNum
                //发出分页请求
                this.list()
            },
            handlePageSizeChange(pageSize) {
                this.pageSize = pageSize
                this.list()
            }
        }
    }
</script>