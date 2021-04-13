<template>
  <div
    style="background-image: linear-gradient(to top right,#845EC2,#D65DB1,#FF6F91,#FF9671); min-height : 100vh;"
  >
    <b-container>
      <b-row>
        <b-col cols="2" sm="2" md="2" lg="2" xl="2"></b-col>
        <b-col cols="8" sm="8" md="8" lg="8" xl="8">
          <b-card title="Đăng ký" class="box-register">
            <b-form @submit="onSubmit" @reset="onReset" v-if="show">
              <b-form-group id="input-group-1" class="labell">
                <b-form-input
                  id="input-1"
                  v-model="form.email"
                  type="email"
                  required
                  placeholder="Enter email"
                  class="input-style"
                ></b-form-input>
              </b-form-group>
              <b-form-group id="input-group-2" class="labell">
                <b-form-input
                  id="input-2"
                  v-model="form.name"
                  required
                  placeholder="Enter name"
                  class="input-style"
                ></b-form-input>
              </b-form-group>

              <b-form-group id="input-group-2" class="labell">
                <b-form-input
                  id="input-2"
                  v-model="form.username"
                  required
                  placeholder="Enter username"
                  class="input-style"
                ></b-form-input>
                <p v-if="exist" style="color:red">Tài khoản đã tồn tại</p>
              </b-form-group>
              <b-form-group id="input-group-2" class="labell">
                <b-form-input
                  id="input-2"
                  v-model="form.password"
                  type="password"
                  required
                  placeholder="Enter password"
                  class="input-style"
                ></b-form-input>
              </b-form-group>
              <b-form-group id="input-group-2" class="labell">
                <b-form-input
                  id="input-2"
                  type="password"
                  v-model="form.passwordComfirm"
                  required
                  placeholder="Password comfirm"
                  class="input-style"
                ></b-form-input>
                <p v-if="checkPassword" style="color:red">
                  Mật khẩu không đúng
                </p>
              </b-form-group>
              <div class="btn-style">
                <b-button
                  type="submit"
                  :disabled="exist || checkPassword"
                  style="margin-right: 30px"
                  >Đăng ký</b-button
                >
                <b-button type="reset">Reset</b-button>
              </div>
            </b-form>
            <div style="display: flex; margin-top:10px">
              <router-link to="/login" left>
                Đăng nhập
              </router-link>
            </div>
          </b-card>
          
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import axios from "axios";
import "./main.css";
import Swal from "sweetalert2";
export default {
  data() {
    return {
      form: {
        email: "",
        name: "",
        username: null,
        password: null,
        passwordComfirm: null,
        active: true,
      },
      checkPassword: false,
      exist: false,
      show: true,
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      axios
        .post("http://localhost:8081/api/user", this.form)
        .then((resp) => {
          Swal.fire("Đăng ký thành công", "", "success");
        })
        .catch((error) => {
          Swal.fire("Đăng ký thất bại", "", "danger");
        });
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.email = "";
      this.form.name = "";
      this.form.username = null;
      this.form.password = null;
      this.form.passwordComfirm = null;
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
  watch: {
    "form.username"() {
      axios
        .get("http://localhost:8081/api/user/username/" + this.form.username)
        .then((res) => {
          this.exist = true;
        })
        .catch((error) => {
          this.exist = false;
        });
    },
    "form.passwordComfirm"() {
      if (this.form.passwordComfirm !== this.form.password)
        this.checkPassword = true;
      else this.checkPassword = false;
    },
  },
};
</script>
