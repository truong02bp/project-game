<template>
  <div style="background : pink; min-height : 100vh">
    <b-container class="bv-example-row">
      <b-row>
        <b-col col="4"></b-col>
        <b-col cols="6">
          <div style="margin-top: 70px">
            <b-card
              title="Đăng nhập"
              img-src="https://picsum.photos/600/300/?image=25"
              img-alt="Image"
              img-top
              tag="article"
              style="max-width: 300rem;"
              class="mb2"
            >
              <b-form
                @submit="onSubmit"
                @reset="onReset"
                v-if="show"
                style="margin-left: 10px;"
              >
                <b-form-input
                  id="input-1"
                  v-model="form.username"
                  type="text"
                  required
                  placeholder="Username"
                  class="input-style"
                ></b-form-input>
                <b-form-input
                  id="input-2"
                  v-model="form.password"
                  type="password"
                  required
                  placeholder="Password"
                  class="input-style"
                ></b-form-input>
                <div class="btn-style">
                  <b-button
                    type="submit"
                    variant="primary"
                    style="margin-right: 30px"
                    >Đăng nhập</b-button
                  >
                  <router-link to="/register">
                    <b-button variant="danger">Đăng ký</b-button></router-link
                  >
                </div>
              </b-form>
            </b-card>
          </div>
        </b-col>
        <b-col col="2"></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import "./main.css";
export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.username = "";
      this.form.password = "";
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style></style>
