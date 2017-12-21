package com.websystique.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.objetos.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.objetos.TipoObjeto;
import com.websystique.spring.service.JugadorService;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.PersonajeService;
import com.websystique.spring.service.TipoObjetoService;
import java.util.Date;
import org.springframework.core.env.Environment;

public class AppMain {

    public static void main(String args[]) {
       
        Creador.crearElRol();

//        // probar si se guardo correctamente
//        long l = 1l;
//        Jugador jug = js.findById(l);
//        if (jug != null) {
//            BonoExp be = new BonoExp();
//            be.setPj(jug.getPj());
//            be.setAplicado(true);
//            be.setBono(100);
//            be.setMotivo("Pruebas Dos");
//            java.util.Date fecha = new Date();
//            be.setFecha(fecha);
//            HibernateDao.darBonoExp(be);
//
//            System.out.println("****   Jugador Creado   *****");
//            System.out.println(jug);
//        }

        //jug = js.findById(l);
//        long l = 1l;
//        Personaje pje = ps.findById(l);
//        System.out.println("****   Personaje Creado   *****");
//        System.out.println(pje);
//        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
//        for (TipoObjeto o : tobjs) {
//            System.out.println(o);
//        }
//        TipoObjeto to = new TipoObjeto();
//        to.setNombre("Cosos 1");
//        to.setDegradado(100);
//        to.setDurabilidad_stnd(999999);
//        to.setPeso_stnd(10);
//        to.setTam_stnd(99);
//        //t_obj_service.saveTipoObjeto(to);
//        
//        ObjetoService obj_service = (ObjetoService) context.getBean("objetoService");
//        Objeto anillo = new Objeto();
//        anillo.setDegradado_actual(1000);
//        anillo.setNombre("Anillo");  
//        TipoObjeto to2 = tobjs.get(0);
//        anillo.setTipo(to2);
//        obj_service.saveObjeto(anillo);
        /*
		 * Create Employee1
         */
//        Employee employee1 = new Employee();
//        employee1.setName("Han Yenn");
//        employee1.setJoiningDate(new LocalDate(2010, 10, 10));
//        employee1.setSalary(new BigDecimal(10000));
//        employee1.setSsn("ssn00000001");

        /*
		 * Create Employee2
         */
//        Employee employee2 = new Employee();
//        employee2.setName("Dan Thomas");
//        employee2.setJoiningDate(new LocalDate(2012, 11, 11));
//        employee2.setSalary(new BigDecimal(20000));
//        employee2.setSsn("ssn00000002");

        /*
		 * Persist both Employees
         */
//        emp_service.saveEmployee(employee1);
//        emp_service.saveEmployee(employee2);

        /*
		 * Get all employees list from database
         */
//        List<Objeto> objs = obj_service.findAllObjetos();
//        for (Objeto o : objs) {
//            System.out.println(o);
//        }

        /*
		 * delete an employee
         */
 /*
		 * update an employee
         */
//        Employee employee = emp_service.findBySsn("ssn00000001");
//        employee.setSalary(new BigDecimal(50000));
//        emp_service.updateEmployee(employee);

        /*
		 * Get all employees list from database
         */
//        List<Employee> employeeList = emp_service.findAllEmployees();
//        for (Employee emp : employeeList) {
//            System.out.println(emp);
//        }
        //context.close();
    }
}
