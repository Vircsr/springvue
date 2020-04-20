<template>
  <div class="backgroundImg">
    <nav-menu class="nav-menu"></nav-menu>
    <router-view/>
  </div>
</template>
<script>
  import NavMenu from '@/components/common/NavMenu'
  // import bgUrl from '@/assets/img/bg/background.jpg'
  export default {
    components: {NavMenu}
  }
</script>

<style>
  .backgroundImg{
    background: url('../assets/img/bg/background.jpg');
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
  }
  .nav-menu {
    /*margin-bottom: 40px;*/
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
  }
</style>
