import "../styles/App.css";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";

const Register = () => {
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
      <h2>Registro</h2>
      <form onSubmit={handleSubmit(customSubmit)} className="form-react">
        <div className="control-formulario">
          <label>Nombre</label>
          <input type="text" {...register("nombres", { required: true })} />
          {errors.nombres && (
            <small className="error"> El campo no puede estar vacío</small>
          )}
        </div>

        <div className="control-formulario">
          <label>Edad</label>
          <input
            type="number"
            {...register("edad", { required: true, min: 18, max: 100 })}
          />
          {errors.edad?.type === "required" && (
            <small className="error"> El campo no puede estar vacío</small>
          )}
          {errors.edad?.type === "min" && (
            <small className="error"> La edad no es válida</small>
          )}
          {errors.edad?.type === "max" && (
            <small className="error"> La edad no es válida</small>
          )}
        </div>

        <div className="control-formulario">
          <label>Foto de Perfil</label>
          <input type="file"></input>
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

        <button type="submit">REGISTRARSE</button>
      </form>
    </>
  );
};

export default Register;
