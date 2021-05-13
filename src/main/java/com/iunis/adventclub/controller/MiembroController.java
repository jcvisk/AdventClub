package com.iunis.adventclub.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.iunis.adventclub.domain.*;
import com.iunis.adventclub.helpers.CommonsHelpers;
import com.iunis.adventclub.service.*;
import com.iunis.adventclub.utilities.DateUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@Slf4j
public class MiembroController {

    @Autowired
    AsociacionService asociacionService;
    @Autowired
    DistritoService distritoService;
    @Autowired
    IglesiaService iglesiaService;
    @Autowired
    ClubService clubService;
    @Autowired
    ClaseService claseService;
    @Autowired
    MiembroService miembroService;
    @Autowired
    PeriodoeclesiasticoService periodoService;
    @Autowired
    ServletContext servletContext;

    private final TemplateEngine templateEngine;

    public MiembroController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping(value = "/miembroDisplay")
    public String miembroDisplay(Miembro miembro, Model model) {
        Iterable<Miembro> miembroList = miembroService.findMiembroByEstatusActivo();
        model.addAttribute("miembros", miembroList);

        //enviando miembroUpdate vacio para eviatr errores en el modal de edicion
        model.addAttribute("miembroUpdate", miembro);
        return "miembro";
    }

    @GetMapping(value = "/inscripcionDisplay")
    public String inscripFormAdmin(Miembro miembro, Model model) {

        //Mandando una lista de las asociaciones activas
        Iterable<Asociacion> asociacionList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionList);

        model.addAttribute("asociacionSeleccionada", "0");

        return "inscripcionesbyadmin";
    }

    @PostMapping(value = "/inscripcionDisplay")
    public String inscripFormAdminSelects(Miembro miembro, Asociacion asociacion, Distrito distrito, Iglesia iglesia, Club club, Clase clase, Model model) {
        //Mandando una lista de las asociaciones activas
        Iterable<Asociacion> asociacionList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionList);
        //Mandando una asociacion seleccionada
        model.addAttribute("asociacionSelected", asociacion.getId());

        if ((asociacion.getId() > 0) && (asociacion.getId() != null)) {
            Iterable<Distrito> distritos = distritoService.findDistritosByIdAsociacion(asociacion.getId());
            model.addAttribute("distritos", distritos);
            model.addAttribute("distritoSelected", distrito.getId());

            if ((distrito.getId() != null) && (distrito.getId() > 0)) {
                Iterable<Iglesia> iglesias = iglesiaService.findIglesiasByIdDistrito(distrito.getId());
                model.addAttribute("iglesias", iglesias);
                model.addAttribute("iglesiaSelected", iglesia.getId());

                if ((iglesia.getId() != null) && (iglesia.getId() > 0)) {
                    Iterable<Club> clubs = clubService.findClubesByIdIglesia(iglesia.getId());
                    model.addAttribute("clubes", clubs);
                    model.addAttribute("clubSelected", club.getId());

                    if ((club.getId() != null) && (club.getId() > 0)) {
                        Iterable<Clase> clases = claseService.findClasesByIdClub(club.getId());
                        model.addAttribute("clases", clases);

                    }
                }
            }
        }

        return "inscripcionesbyadmin";
    }

    /**
     * Guarda el miembro y redirige a miembroDisplay
     *
     * @param miembro
     * @return /miembroDisplay
     */
    @PostMapping(value = "/inscripcionDisplay", params = "action=save")
    public String inscripFormSaveAdmin(Miembro miembro) {
        miembroService.createMiembro(miembro);

        return "redirect:/miembroDisplay";
    }

    /**
     * En primera instancia muestra el formulario y la lista de asociaicones
     *
     * @param miembro
     * @param model
     * @return
     */
    @GetMapping(value = "/inscripcionForm")
    public String inscripFormUser(Miembro miembro, Model model) {

        //Mandando una lista de las asociaciones activas
        Iterable<Asociacion> asociacionList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionList);

        model.addAttribute("asociacionSeleccionada", "0");

        return "inscripcion";
    }

    /**
     * Recibe los id y verifica si existen distritos, iglesias, clubes, clases y regresa al formulario con los valores cargados
     *
     * @param miembro
     * @param asociacion
     * @param distrito
     * @param iglesia
     * @param club
     * @param model
     * @return
     */
    @PostMapping(value = "/inscripcionForm")
    public String inscripFormUserSelects(Miembro miembro, Asociacion asociacion, Distrito distrito, Iglesia iglesia, Club club, Model model) {
        //Mandando una lista de las asociaciones activas
        Iterable<Asociacion> asociacionList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionList);
        //Mandando una asociacion seleccionada
        model.addAttribute("asociacionSelected", asociacion.getId());

        if ((asociacion.getId() > 0) && (asociacion.getId() != null)) {
            Iterable<Distrito> distritos = distritoService.findDistritosByIdAsociacion(asociacion.getId());
            model.addAttribute("distritos", distritos);
            model.addAttribute("distritoSelected", distrito.getId());

            if ((distrito.getId() != null) && (distrito.getId() > 0)) {
                Iterable<Iglesia> iglesias = iglesiaService.findIglesiasByIdDistrito(distrito.getId());
                model.addAttribute("iglesias", iglesias);
                model.addAttribute("iglesiaSelected", iglesia.getId());

                if ((iglesia.getId() != null) && (iglesia.getId() > 0)) {
                    Iterable<Club> clubs = clubService.findClubesByIdIglesia(iglesia.getId());
                    model.addAttribute("clubes", clubs);
                    model.addAttribute("clubSelected", club.getId());

                    if ((club.getId() != null) && (club.getId() > 0)) {
                        Iterable<Clase> clases = claseService.findClasesByIdClub(club.getId());
                        model.addAttribute("clases", clases);

                    }
                }
            }
        }

        return "inscripcion";
    }

    @PostMapping(value = "/inscripcionForm", params = "action=save")
    public String inscripFormSaveUser(Miembro miembro) {

        Collection<Periodoeclesiastico> periodos = periodoService.findFechasByIdClub(miembro.getClub().getId());
        Date fechaActual = new Date();

        if (periodos.size() > 0) {
            for (Periodoeclesiastico periodo : periodos) {
                /**
                 * si la fecha de hoy es menor a la fecha de inicio o
                 * si la fecha de hoy es mayor a la fecha de fin
                 */
                if (fechaActual.before(periodo.getInicioinscripcion()) || fechaActual.after(periodo.getFininscripcion())) {
                    return "redirect:/inscripcionAlertModal?id=" + periodo.getId() + "&alertModal=true";
                }

                /**si la fecha de hoy es igual a la fecha de inicio o
                 * si la fehca de hoy es mayor a la fecha de inicio y
                 * si la fecha de hoy es menor a la fecha de fin
                 */
                if (DateUtilities.dateToString(fechaActual).equals(DateUtilities.dateToString(periodo.getInicioinscripcion()))
                        || (fechaActual.after(periodo.getInicioinscripcion()) && fechaActual.before(periodo.getFininscripcion()))) {

                    miembroService.createMiembro(miembro);
                    return "redirect:/getPDF?id=" + miembro.getId();
                }
            }
        } else {
            miembroService.createMiembro(miembro);
            return "redirect:/getPDF?id=" + miembro.getId();
        }
        return "inscripcion";
    }

    @GetMapping(value = "/inscripcionAlertModal")
    public String inscripAlertModal(Miembro miembro, Periodoeclesiastico idPeriodo, Model model) {

        //Mandando una lista de las asociaciones activas
        Iterable<Asociacion> asociacionList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionList);

        model.addAttribute("asociacionSeleccionada", "0");

        //mandando los datos de las fechas de inscripcion
        Periodoeclesiastico p = periodoService.findPeriodoById(idPeriodo);
        model.addAttribute("fechaInicio", p.getInicioinscripcion());
        model.addAttribute("fechaFin", p.getFininscripcion());

        return "inscripcion";
    }

    @GetMapping(value = "/reimpresion")
    public String reimpresion(Miembro miembro){
        return "reimpresion";
    }

    @RequestMapping(value = "/getPDF")
    public ResponseEntity<?> crearPDF(HttpServletRequest request, HttpServletResponse response, Miembro idMiembro) throws IOException {
        //llamar la logica de negocio (obtener los datos del miembro)
        Miembro miembro = miembroService.findMiembroById(idMiembro);

        WebContext webContext = new WebContext(request, response, servletContext);
        webContext.setVariable("miembro", miembro);
        String htmlGenerate = templateEngine.process("pdfTemplate", webContext);
        //Convertirlo a bites
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //convertir las propiedades
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(CommonsHelpers.getBaseUrl(request));
        HtmlConverter.convertToPdf(htmlGenerate, outputStream, converterProperties);
        //extraer el pdf
        byte[] bytes = outputStream.toByteArray();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(bytes);
    }

    @GetMapping(value = "/miembroUpdate")
    public String update(Miembro miembro, Miembro idMiembro, Model model) {
        //mandando la lista de miembros
        Iterable<Miembro> miembroList = miembroService.findMiembroByEstatusActivo();
        model.addAttribute("miembros", miembroList);

        //mandando el objeto miembro lleno
        Miembro miembroFull = miembroService.findMiembroById(idMiembro);
        model.addAttribute("miembroUpdate", miembroFull);

        //mandando la lista de clases
        Iterable<Clase> clases = claseService.findClasesByIdClub(miembroFull.getClub().getId());
        model.addAttribute("clases", clases);

        //mandando la clase seleccionada
        model.addAttribute("claseSelected", miembroFull.getClase().getId());
        //mandando el club
        model.addAttribute("clubSelect", miembroFull.getClub().getId());


        return "miembro";
    }

    @GetMapping(value = "/miembroDelete")
    public String delete(Miembro miembro) {
        miembro = miembroService.findMiembroById(miembro);
        miembroService.deleteMiembro(miembro);
        return "redirect:/miembroDisplay";
    }
}
