/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


/*!40000 ALTER TABLE `documentos_origen` DISABLE KEYS */;
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('COMPRAS','COMP',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('COTIZACIONES','COT',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('PREVIO COMPRAS','PREV',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('PROVEEDORES','PROV',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('REMISIONES','REM',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('ORDENES COMPRA','ORDC',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('PEDIDOS','PED',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('PAGOS','CXC',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('FACTURAS','FAC',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('NOTAS DE CRÉDITO CLIENTES','NOTC',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('NOTAS DE CRÉDITO PROVEEDORES','NOTP',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('TICKETS','TIK',now(),now());
INSERT INTO documentos_origen(nombre,tipo,falt,fmod) VALUES('CLIENTES','EMP',now(),now());
/*!40000 ALTER TABLE `documentos_origen` ENABLE KEYS */;

/*!40000 ALTER TABLE `almas` DISABLE KEYS */;
INSERT INTO almas(code,almadescrip,estac,sucu,nocaj,respon, falt,fmod) VALUES('SYS','ALMACÉN GENÉRICO','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO almas(code,almadescrip,estac,sucu,nocaj,respon, falt,fmod) VALUES('ACTFIJ','ACTIVO FIJO','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO almas(code,almadescrip,estac,sucu,nocaj,respon, falt,fmod) VALUES('GENERAL','GENERAL','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO almas(code,almadescrip,estac,sucu,nocaj,respon, falt,fmod) VALUES('VTAS','VENTAS','INICIAL','INICIAL','INICIAL','',now(),now());
/*!40000 ALTER TABLE `almas` ENABLE KEYS */;

/*!40000 ALTER TABLE `emps` DISABLE KEYS */;
INSERT INTO emps(cod,cashCustomer,codclas,nom,RFC,descu,deposit,otramon,otramonc,cta,diapag,limtcred,bloq,bloqlimcred,list,estac,sucu,nocaj,beneficiario,usocfdi,falt,fmod)
   VALUES('EMPMOS',1,'SYS','PUBLICO GENERAL','XAXX010101000',0,0,1,1,'000',0,0,0,0,1,'INICIAL','INICIAL','INICIAL','','',now(),now());   
/*!40000 ALTER TABLE `emps` ENABLE KEYS */;


/*!40000 ALTER TABLE `conceps` DISABLE KEYS */;
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('AIN','AJUSTE POR INVENTARIO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('MER','MERMA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('ROB','ROBO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('MAL','MALESTADO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('COM','COMPRA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('CAD','CADUCO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('ROT','ROTO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('DEF','DEFECTUOSO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('MOJ','MOJADO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('SINC','SIN CAJA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('PROMO','PROMOCIÓN','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('CORTE','CORTESÍA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('OFER','OFERTA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('NOFUN','NO FUNCIONA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('SALG','SALIDA GENERICA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('ENTG','ENTRADA GENERICA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('MERMA','MERMA A GRANEL','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('PROR','PRORATEO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('DONA','DONACIONES','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('TRAS','TRASPASO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('VENTA','VENTA DE PRODUCTO','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('CANVENTA','CANCELACION DE VENTA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('DEVVENTA','DEVOLUCION DE VENTA','INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO conceps(code,descrip,estac,sucu,nocaj,falt,fmod) VALUES('DEVPVENTA','DEVOLUCION PARCIAL DE VENTA','INICIAL','INICIAL','INICIAL',now(),now());
/*!40000 ALTER TABLE `conceps` ENABLE KEYS */;

/*!40000 ALTER TABLE `confgral` DISABLE KEYS */;
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','systemintest',1,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevporusuario',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevmonac',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevmodesc',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevmodprec',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevunavezser',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('prev','prevobligarser',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(extr,clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('RESP','resp','respaut',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'inv','esexitmov',1,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'inv','traspasexis',1,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'inv','igualser',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,nume) VALUES(0,'sist','redon',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',0);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','tipcamtod',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','mostmsjusr',1,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','usrmulti',1,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','calc',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','cuader',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','apfavo',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES(30,'sist','agrad',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(dia,clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES(0,'sist','cfdi33',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,nume, falt,fmod,estac,sucu,nocaj) VALUES('sist','posdecimal',0,4, now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('sist','cumple',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('sist','dlogin',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','venunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vencotunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','venunaserpv',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','logorem',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','slimcredrem',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vremptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','imprempto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','canrempto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('rems','vercanrem',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('rems','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr) VALUES('vtas','moddescrip',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','monfacfij',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr) VALUES('vtas','serfacfij',0,now(),now(),'INICIAL','INICIAL','INICIAL','FAC');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,nume) VALUES('vtas','minfac',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',100);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr) VALUES('vtas','almavtaf',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','devvtaspto',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','devpvtaspto',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','modlistfac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','garandescfac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','garandescpto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','modprec',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','almapto',0,'SYS',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','serfac',0,'FAC',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','sertic',0,'TIK',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','serrem',0,'REM',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','hoyvtap',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','autcortx',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','modp',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','clavsegfac',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','clavsegfacp',0,'',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj) VALUES('vtas','insautcaj',0,'0',now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','chatptoc',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vmsjpto',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','guapdfcanf',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vercanvtaf',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vercanvta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','admcanvtas',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','descrippto',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','empspto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','canfacpto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','canticpto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','impfacpto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','impticpto',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vfacptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vticptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','cortxa',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','cortza',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vtasxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','slimcredpvta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','slimcredfac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','logofac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','logotik',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','alistpreclifac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','alistpreclipvta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','initpvta',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','msjexistnegfac',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','msjexistnegpvta',0,now(),now(),'INICIAL','INICIAL','NOCAJ');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vendsinexistpvta',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','vendsinexistfac',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','catgralpvta',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','catgralfac',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','cotunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','msjexistnegpcot',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','cotconaser',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr) VALUES('cots','moddescrip',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr) VALUES('cots','almavtac',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','modlistcot',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','garadesccot',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','modprec',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','cotsxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','alistpreclicot',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','msjexistnegcot',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('cots','vendsinexistcot',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','barlat',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('vtas','imglin',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','iniord',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','modprec',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','vercancom',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','compsxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL');
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj) VALUES('comps','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL');
/*!40000 ALTER TABLE `confgral` ENABLE KEYS */;

/*!40000 ALTER TABLE `consecs` DISABLE KEYS */;
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('PREV','PREV','PREVIOS DE COMPRA',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('NOTC','NOTC','NOTAS DE CRÉDITO CLIENTES',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('NOTP','NOTP','NOTAS DE CRÉDITO PROVEEDORES',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('FAC','FAC','FACTURAS',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('TIK','TIK','TICKETS',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('COT','COT','COTIZACIONES',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('EMP','EMP','EMPRESAS',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('PROV','PROV','PROVEEDORES',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('REM','REM','REMISIONES',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('COMP','COMP','COMPRAS',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('ORDC','ORDC','ORDENES COMPRA',1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('CXC','PAG','PAGOS', 1, 'INICIAL', 'INICIAL', 'INICIAL',now(),now());
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,falt,fmod) VALUES('PED','PED','PEDIDOS', 1, 'INICIAL', 'INICIAL', 'INICIAL',now(),now());
/*!40000 ALTER TABLE `consecs` ENABLE KEYS */;

/*!40000 ALTER TABLE `estacs` DISABLE KEYS */;
INSERT INTO estacs(code,nom,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj,vend,supervisor) 
VALUES('SUP','SUPERVISOR',0,100,1,1,'9DEfUOPdQkt/Iw9/mM1MfA==','INICIAL','INICIAL','INICIAL',now(),now(),1,1,1);
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj) 
VALUES('RESPALDO',0,0,0,1,'sf3jnIQUKGGrhytrjFxAPg==','INICIAL','INICIAL','INICIAL',now(),now(),0);
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj) 
VALUES('COMPRAS',0,0,1,1,'Z71yeW61FlqLsOh6dL6gnA==','INICIAL','INICIAL','INICIAL',now(),now(),0);
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj,vend,almacen) 
VALUES('VENTAS',0,0,1,1,'cZ/+xadtjzmhD+z/HxaDHw==','INICIAL','INICIAL','INICIAL',now(),now(),0,1,'GENERAL');
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj) 
VALUES('CAJA',0,0,1,1,'DmwHMlUjJPWH7rFQm7tRdg==','INICIAL','INICIAL','INICIAL',now(),now(),0);
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj) 
VALUES('CXC',0,0,1,1,'v3hbr8zAMljzm1LtdTf9aA==','INICIAL','INICIAL','INICIAL',now(),now(),0);
INSERT INTO estacs(code,`52m`,descu,habdesc,cort,pass,estac,sucu,nocaj,falt,fmod,admcaj) 
VALUES('CXP',0,0,1,1,'6jJCUgl3ONyrX0xEa7yxQw==','INICIAL','INICIAL','INICIAL',now(),now(),0);
/*!40000 ALTER TABLE `estacs` ENABLE KEYS */;

/*!40000 ALTER TABLE `impues` DISABLE KEYS */;
INSERT INTO impues(code, reten, impueval, estac, sucu, nocaj, impuestoXML,falt,fmod) VALUES
	('IEPS', b'0', 8, 'INICIAL', 'INICIAL', 'INICIAL',  'Traslado IVA',now(),now()),
	('IVA', b'0', 16, 'SUP', 'SUCURSAL', 'CAJA',  'Traslado IVA',now(),now()),
	('ISR', b'1', 4, 'SUP', 'SUCURSAL', 'CAJA',  'Retención ISR',now(),now()),
	('RETENCION', b'1', 4, 'SUP', 'SUCURSAL', 'CAJA', 'Retención IVA',now(),now()),
	('IVA10.66', b'1', 10.6667, 'SUP', 'SUCURSAL', 'CAJA', 'Retención IVA',now(),now()),
	('ISR10', b'1', 10, 'SUP', 'SUCURSAL', 'CAJA',  'Retención ISR',now(),now()),
	('ISH', b'0', 1.99, 'SUP', 'SUCURSAL', 'CAJA', 'Traslado IVA',now(),now()),
	('ISH3', b'0', 3, 'SUP', 'SUCURSAL', 'CAJA',  'Traslado IVA',now(),now()),
	('RETENCION16', b'1', 16, 'SUP', 'SUCURSAL', 'CAJA', 'Retención IVA',now(),now());
/*!40000 ALTER TABLE `impues` ENABLE KEYS */;
	
	
/*!40000 ALTER TABLE `lins` DISABLE KEYS */;
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('SYS','LÍNEA GENERICA',-1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('FRUTAS','FRUTAS',-1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('VERDURAS','VERDURAS',-1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('LACTEOS','LACTEOS',-1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('VINOS','VINOS',-1,'INICIAL','INICIAL','INICIAL',now(),now());
INSERT INTO lins(code,descrip,img,estac,sucu,nocaj,falt,fmod)
VALUES ('PLASTICOS','PLASTICOS',-1,'INICIAL','INICIAL','INICIAL',now(),now());
/*!40000 ALTER TABLE `lins` ENABLE KEYS */;



/*!40000 ALTER TABLE `meds` DISABLE KEYS */;
INSERT INTO meds(code,descrip,estac,sucu,nocaj,falt,fmod)
VALUES('SYS','MEDIDA GENERICA','INICIAL', 'INICIAL', 'INICIAL',now(),now());
/*!40000 ALTER TABLE `meds` ENABLE KEYS */;



/*!40000 ALTER TABLE `mons` DISABLE KEYS */;

INSERT INTO `mons` (`c_moneda_id`, `c_Moneda`, `Descripcion`, `Decimales`, `Porcentaje_variación`, `Fecha_inicio_de_vigencia`,`falt`,`fmod`,`simb`) VALUES
(100, 'MXN', 'Peso Mexicano', '2', 500, '2017-08-14 00:00:00', now(),now(),'$');

INSERT INTO `mons` (`c_moneda_id`, `c_Moneda`, `Descripcion`, `Decimales`, `Porcentaje_variación`, `Fecha_inicio_de_vigencia`,`falt`,`fmod`) VALUES
	(1, 'AED', 'Dirham de EAU', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(2, 'AFN', 'Afghani', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(3, 'ALL', 'Lek', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(4, 'AMD', 'Dram armenio', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(5, 'ANG', 'Florín antillano neerlandés', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(6, 'AOA', 'Kwanza', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(7, 'ARS', 'Peso Argentino', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(8, 'AUD', 'Dólar Australiano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(9, 'AWG', 'Aruba Florin', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(10, 'AZN', 'Azerbaijanian Manat', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(11, 'BAM', 'Convertibles marca', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(12, 'BBD', 'Dólar de Barbados', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(13, 'BDT', 'Taka', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(14, 'BGN', 'Lev búlgaro', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(15, 'BHD', 'Dinar de Bahrein', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(16, 'BIF', 'Burundi Franc', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(17, 'BMD', 'Dólar de Bermudas', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(18, 'BND', 'Dólar de Brunei', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(19, 'BOB', 'Boliviano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(20, 'BOV', 'Mvdol', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(21, 'BRL', 'Real brasileño', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(22, 'BSD', 'Dólar de las Bahamas', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(23, 'BTN', 'Ngultrum', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(24, 'BWP', 'Pula', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(25, 'BYR', 'Rublo bielorruso', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(26, 'BZD', 'Dólar de Belice', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(27, 'CAD', 'Dolar Canadiense', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(28, 'CDF', 'Franco congoleño', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(29, 'CHE', 'WIR Euro', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(30, 'CHF', 'Franco Suizo', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(31, 'CHW', 'Franc WIR', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(32, 'CLF', 'Unidad de Fomento', '4', 500, '2017-08-14 00:00:00', now(),now()),
	(33, 'CLP', 'Peso chileno', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(34, 'CNY', 'Yuan Renminbi', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(35, 'COP', 'Peso Colombiano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(36, 'COU', 'Unidad de Valor real', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(37, 'CRC', 'Colón costarricense', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(38, 'CUC', 'Peso Convertible', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(39, 'CUP', 'Peso Cubano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(40, 'CVE', 'Cabo Verde Escudo', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(41, 'CZK', 'Corona checa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(42, 'DJF', 'Franco de Djibouti', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(43, 'DKK', 'Corona danesa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(44, 'DOP', 'Peso Dominicano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(45, 'DZD', 'Dinar argelino', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(46, 'EGP', 'Libra egipcia', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(47, 'ERN', 'Nakfa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(48, 'ETB', 'Birr etíope', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(49, 'EUR', 'Euro', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(50, 'FJD', 'Dólar de Fiji', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(51, 'FKP', 'Libra malvinense', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(52, 'GBP', 'Libra Esterlina', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(53, 'GEL', 'Lari', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(54, 'GHS', 'Cedi de Ghana', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(55, 'GIP', 'Libra de Gibraltar', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(56, 'GMD', 'Dalasi', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(57, 'GNF', 'Franco guineano', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(58, 'GTQ', 'Quetzal', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(59, 'GYD', 'Dólar guyanés', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(60, 'HKD', 'Dolar De Hong Kong', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(61, 'HNL', 'Lempira', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(62, 'HRK', 'Kuna', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(63, 'HTG', 'Gourde', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(64, 'HUF', 'Florín', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(65, 'IDR', 'Rupia', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(66, 'ILS', 'Nuevo Shekel Israelí', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(67, 'INR', 'Rupia india', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(68, 'IQD', 'Dinar iraquí', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(69, 'IRR', 'Rial iraní', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(70, 'ISK', 'Corona islandesa', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(71, 'JMD', 'Dólar Jamaiquino', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(72, 'JOD', 'Dinar jordano', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(73, 'JPY', 'Yen', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(74, 'KES', 'Chelín keniano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(75, 'KGS', 'Som', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(76, 'KHR', 'Riel', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(77, 'KMF', 'Franco Comoro', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(78, 'KPW', 'Corea del Norte ganó', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(79, 'KRW', 'Won', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(80, 'KWD', 'Dinar kuwaití', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(81, 'KYD', 'Dólar de las Islas Caimán', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(82, 'KZT', 'Tenge', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(83, 'LAK', 'Kip', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(84, 'LBP', 'Libra libanesa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(85, 'LKR', 'Rupia de Sri Lanka', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(86, 'LRD', 'Dólar liberiano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(87, 'LSL', 'Loti', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(88, 'LYD', 'Dinar libio', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(89, 'MAD', 'Dirham marroquí', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(90, 'MDL', 'Leu moldavo', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(91, 'MGA', 'Ariary malgache', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(92, 'MKD', 'Denar', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(93, 'MMK', 'Kyat', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(94, 'MNT', 'Tugrik', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(95, 'MOP', 'Pataca', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(96, 'MRO', 'Ouguiya', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(97, 'MUR', 'Rupia de Mauricio', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(98, 'MVR', 'Rupia', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(99, 'MWK', 'Kwacha', '2', 500, '2017-08-14 00:00:00', now(),now()),	
	(101, 'MXV', 'México Unidad de Inversión (UDI)', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(102, 'MYR', 'Ringgit malayo', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(103, 'MZN', 'Mozambique Metical', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(104, 'NAD', 'Dólar de Namibia', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(105, 'NGN', 'Naira', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(106, 'NIO', 'Córdoba Oro', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(107, 'NOK', 'Corona noruega', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(108, 'NPR', 'Rupia nepalí', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(109, 'NZD', 'Dólar de Nueva Zelanda', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(110, 'OMR', 'Rial omaní', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(111, 'PAB', 'Balboa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(112, 'PEN', 'Nuevo Sol', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(113, 'PGK', 'Kina', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(114, 'PHP', 'Peso filipino', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(115, 'PKR', 'Rupia de Pakistán', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(116, 'PLN', 'Zloty', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(117, 'PYG', 'Guaraní', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(118, 'QAR', 'Qatar Rial', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(119, 'RON', 'Leu rumano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(120, 'RSD', 'Dinar serbio', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(121, 'RUB', 'Rublo ruso', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(122, 'RWF', 'Franco ruandés', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(123, 'SAR', 'Riyal saudí', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(124, 'SBD', 'Dólar de las Islas Salomón', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(125, 'SCR', 'Rupia de Seychelles', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(126, 'SDG', 'Libra sudanesa', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(127, 'SEK', 'Corona sueca', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(128, 'SGD', 'Dolar De Singapur', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(129, 'SHP', 'Libra de Santa Helena', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(130, 'SLL', 'Leona', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(131, 'SOS', 'Chelín somalí', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(132, 'SRD', 'Dólar de Suriname', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(133, 'SSP', 'Libra sudanesa Sur', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(134, 'STD', 'Dobra', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(135, 'SVC', 'Colon El Salvador', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(136, 'SYP', 'Libra Siria', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(137, 'SZL', 'Lilangeni', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(138, 'THB', 'Baht', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(139, 'TJS', 'Somoni', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(140, 'TMT', 'Turkmenistán nuevo manat', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(141, 'TND', 'Dinar tunecino', '3', 500, '2017-08-14 00:00:00', now(),now()),
	(142, 'TOP', 'Pa\'anga', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(143, 'TRY', 'Lira turca', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(144, 'TTD', 'Dólar de Trinidad y Tobago', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(145, 'TWD', 'Nuevo dólar de Taiwán', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(146, 'TZS', 'Shilling tanzano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(147, 'UAH', 'Hryvnia', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(148, 'UGX', 'Shilling de Uganda', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(149, 'USD', 'Dolar americano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(150, 'USN', 'Dólar estadounidense (día siguiente)', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(151, 'UYI', 'Peso Uruguay en Unidades Indexadas (URUIURUI)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(152, 'UYU', 'Peso Uruguayo', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(153, 'UZS', 'Uzbekistán Sum', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(154, 'VEF', 'Bolívar', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(155, 'VND', 'Dong', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(156, 'VUV', 'Vatu', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(157, 'WST', 'Tala', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(158, 'XAF', 'Franco CFA BEAC', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(159, 'XAG', 'Plata', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(160, 'XAU', 'Oro', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(161, 'XBA', 'Unidad de Mercados de Bonos Unidad Europea Composite (EURCO)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(162, 'XBB', 'Unidad Monetaria de Bonos de Mercados Unidad Europea (UEM-6)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(163, 'XBC', 'Mercados de Bonos Unidad Europea unidad de cuenta a 9 (UCE-9)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(164, 'XBD', 'Mercados de Bonos Unidad Europea unidad de cuenta a 17 (UCE-17)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(165, 'XCD', 'Dólar del Caribe Oriental', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(166, 'XDR', 'DEG (Derechos Especiales de Giro)', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(167, 'XOF', 'Franco CFA BCEAO', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(168, 'XPD', 'Paladio', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(169, 'XPF', 'Franco CFP', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(170, 'XPT', 'Platino', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(171, 'XSU', 'Sucre', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(172, 'XTS', 'Códigos reservados específicamente para propósitos de prueba', '0', 0, '2017-08-14 00:00:00',now(),now()),
	(173, 'XUA', 'Unidad ADB de Cuenta', '0', 500, '2017-08-14 00:00:00', now(),now()),
	(174, 'XXX', 'Los códigos asignados para las transacciones en que intervenga ninguna moneda', '0', 0, '2017-08-14 00:00:00',now(),now()),
	(175, 'YER', 'Rial yemení', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(176, 'ZAR', 'Rand', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(177, 'ZMW', 'Kwacha zambiano', '2', 500, '2017-08-14 00:00:00', now(),now()),
	(178, 'ZWL', 'Zimbabwe Dólar', '2', 500, '2017-08-14 00:00:00',now(),now());
/*!40000 ALTER TABLE `mons` ENABLE KEYS */;


	
	
/*!40000 ALTER TABLE `unids` DISABLE KEYS */;
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('KILO','KILO','INICIAL','INICIAL','INICIAL','KGM',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('METROCUADRADO','METROCUADRADO','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('CABEZA','CABEZA','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('KILOWATT','KILOWATT','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('KILOWATT/HORA','KILOWATT/HORA','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('GRAMONETO','GRAMONETO','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('DOCENAS','DOCENAS','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('GRAMO','GRAMO','INICIAL','INICIAL','INICIAL','GRM',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('METROCÚBICO','METROCÚBICO','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('LITRO','LITRO','INICIAL','INICIAL','INICIAL','LTR',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('MILLAR','MILLAR','INICIAL','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('TONELADA','TONELADA','TONELADA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('DECENAS','DECENAS','TONELADA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('CAJA','CAJA','CAJA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('METRO LINEAL','METRO LINEAL','CAJA','INICIAL','INICIAL','LM',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('PIEZA','PIEZA','INICIAL','INICIAL','INICIAL','H87',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('PAR','PAR','CAJA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('JUEGO','JUEGO','CAJA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('BARRIL','BARRIL','CAJA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('CIENTOS','CIENTOS','CAJA','INICIAL','INICIAL','',now(),now());
INSERT INTO unids(code,descrip,estac,sucu,nocaj,clavesat,falt,fmod) VALUES('BOTELLA','BOTELLA','CAJA','INICIAL','INICIAL','',now(),now());
/*!40000 ALTER TABLE `unids` ENABLE KEYS */;

