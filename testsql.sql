/*
Dada la estructura de datos Archivador, Cajón, Documento, Anexo. Donde un Archivador
tiene uno o más Cajones, un Cajón tiene de cero a muchos Documentos y un Documento
tiene de 0 a muchos Anexos, realizar las siguientes queries:
*/

-- Nota: se han utilizado funciones basándose en el motor de base de datos PostgreSQL

-- Ejercicio 1: Obtener la posición de todos los documentos archivados durante 2014
select 
	a.numero as numero_archivo, 
	c.posicion as posicion_cajon,
	d.tipo_documento as tipo_documento,
	d.titulo as titulo_documento,
	d.fecha_archivado as fecha_documento
from archivo a
	inner join cajon c on (a.id = c.archivo_id)
	inner join documento d on (c.id = d.cajon_id)
where extract(year from d.fecha_archivado) = 2014 
order by fecha_documento, numero_archivo asc;

/* Nota: una forma genérica y un poco más eficiente (con índice en fecha_archivado) sería cambiar la función extract por: 
   where d.fecha_archivado >= '2014-01-01' AND d.fecha_archivado <= '2014-12-31'
   la parte interesante de utilizar la función extract es que es independiente del tipo date o timestamp 
   o la representación del formato de la fecha-- una forma genérica y un poco más eficiente (con índice en fecha_archivado) sería cambiar la función extract por: 
   where d.fecha_archivado >= '2014-01-01' AND d.fecha_archivado <= '2014-12-31'
   la parte interesante de utilizar la función extract es que es independiente del tipo date o timestamp 
   o la representación del formato de la fecha
*/

-- Ejercicio 2: Obtener la posición de todos los documentos archivados en 2014 añadiendo 
-- el título de sus anexos de tipo factura en caso de existir
select 
	a.numero as numero_archivo, 
	c.posicion as posicion_cajon,
	d.tipo_documento as tipo_documento,
	d.titulo as titulo_documento,
	d.fecha_archivado as fecha_documento,
	-- PostgreSQL no tiene la función DECODE de Oracle
	(case when an.tipo_anexo = 'factura' then an.titulo else '' end) as titulo_anexo
from archivo a
	inner join cajon c on (a.id = c.archivo_id)
	inner join documento d on (c.id = d.cajon_id)
	left join anexo an on (d.id = an.documento_id)
where extract(year from d.fecha_archivado) = 2014
order by fecha_documento, numero_archivo asc;

-- Ejercicio 3: Contar el número de documentos que tiene al menos un anexo de tipo factura

select count(d.id) as num_doc_anexos
from documento d
where d.id in (
	select documento_id
	from anexo
	where tipo_anexo like 'factura'
	group by documento_id
	having count(tipo_anexo) >= 1
);

-- Esta consulta es más compleja pero muestra el título del documento y la cantidad de anexos
select d.titulo, 
d.tipo_documento,
( select count (documento_id) as num_anexos
	from anexo
	where tipo_anexo like 'factura'
	and documento_id = d.id
	group by documento_id
	having count(tipo_anexo) >= 1
)
from documento d
where d.id in (
	select documento_id
	from anexo
	where tipo_anexo like 'factura'
	group by documento_id
	having count(tipo_anexo) >= 1
)
order by d.titulo;

-- Ejercicio 4: Obtener la posición de todos los documentos y su último anexo de tipo factura, si éste existe.
-- Nota: como la query es un poco más compleja he añadido la columna es_factura con un flag para que pueda 
-- verse el titulo del anexo, cumpla la condición o no.

select 
	a.numero as numero_archivo, 
	c.posicion as posicion_cajon,
	d.tipo_documento as tipo_documento,
	d.titulo as titulo_documento,
	d.fecha_archivado as fecha_documento,
	an.fecha_archivado as fecha_anexo,	
	an.titulo as titulo_anexo,
	-- PostgreSQL no tiene la función DECODE de Oracle
	(case when an.tipo_anexo = 'factura' then true else false end) as es_factura,
	d.id as doc_id,
	an.id as anexo_id,
	an.tipo_anexo
from archivo a
	inner join cajon c on (a.id = c.archivo_id)
	inner join documento d on (c.id = d.cajon_id)
	left join anexo an on (d.id = an.documento_id)
where an.fecha_archivado = (
	select max(fecha_archivado)
	from anexo 
	where (tipo_anexo = an.tipo_anexo and documento_id = an.documento_id)
	-- un documento puede tener varios tipos de anexos, agrupamos para sacar la fecha más reciente por tipo de anexo
	group by (documento_id, tipo_anexo)
	-- tenemos en cuenta que hay documentos sin anexos
) or an.fecha_archivado is null
order by doc_id, anexo_id asc;