<template>
    <div>
       <!-- fixed size navi bar-->
    <el-menu
        style="width: 200px"
        default-active="2"
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon><location /></el-icon>
          <span>Activity 1</span>
        </template>
        <el-menu-item-group title="group 1">
          <el-menu-item index="1-1">one</el-menu-item>
          <el-menu-item index="1-2">two</el-menu-item>
        </el-menu-item-group>

        <!--<el-sub-menu index="1-4">-->
        <!--  <template #title>选项4</template>-->
        <!--  <el-menu-item index="1-4-1">选项4-1</el-menu-item>-->
        <!--</el-sub-menu>-->
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>Activity 2</span>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <el-icon><document /></el-icon>
        <span>Activity 3</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>Activity 4</span>
      </el-menu-item>
    </el-menu>
    </div>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>

</style>