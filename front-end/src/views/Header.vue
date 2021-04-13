<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <b-navbar-nav>
        <b-nav-item>
          <router-link to="/home">Trang chủ </router-link>
        </b-nav-item>

        <!-- Navbar dropdowns -->
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item right>
          <router-link to="/login"> Đăng nhập </router-link>
        </b-nav-item>

        <b-nav-item-dropdown text="Người dùng" right v-if="active">
          <b-dropdown-item href="#">Account</b-dropdown-item>
          <b-dropdown-item href="#">Settings</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
    data() {
        return {
            active : false
        }
    }
};
</script>

<style></style>
