<template>


    <div>
        <Header/>

        <div style="display:flex">
            <!--sidebar-->
            <Aside/>
                <!--content, use router to view-->
                <router-view style="flex: 1"/>


        </div>
    </div>
</template>

<script>
    import Header from "@/components/Header";
    import Aside from  "@/components/Aside"

    export default {
        name: "Layout",
        components: {
            Header,
            Aside
        }
    }
</script>

<style>

</style>
