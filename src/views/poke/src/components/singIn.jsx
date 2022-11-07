import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import "../styles/singIn.css";

const SingIn = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },  //formState para ver los errores
    watch,
  } = useForm(); //llamamos lo que vamos a usar
 

  const customSubmit = (data) => {
    //guardamos los datos
    /*alert("Validacion exitosa");*/
  };

  return (
    <>
      <h2>Inicio de sesión</h2>
      <form onSubmit={handleSubmit(customSubmit)} className="form-react">
        <div className="control-formulario">
          <label>Nombre</label>
          <input type="text" {...register("nombres", { required: true })} />
          {errors.nombres && (
            <small className="error"> El campo no puede estar vacío</small>
          )}
        </div>

        <div className="control-formulario">
          <label>Contraseña</label>
          <input
            type="password"
            {...register("password", { required: true })}
          />
          {errors.password && (
            <small className="error"> El campo no puede estar vacío</small>
          )}
        </div>

        <button type="submit">INICIAR SESION</button>
      </form>
    </>
  );
};

export default SingIn;