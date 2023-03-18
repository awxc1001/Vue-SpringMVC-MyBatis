<template>
<div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc;
display: flex">
<div style="width: 200px; padding-left: 600px; font-weight: bold; color:
dodgerblue">MANAGEMENT</div>
<div style="flex: 1"></div>

<div style="width: 100px">
    <el-dropdown>
    <span class="el-dropdown-link">
      User
      <el-icon class="el-icon--right">
        <arrow-down />
      </el-icon>
    </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item>Personal Info</el-dropdown-item>
        <el-dropdown-item>LogOut</el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</div>

</div>
</template>

<script>
    export default {
        name: ""
    }
</script>

<style scoped>

</style>