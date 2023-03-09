import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/email-field/src/vaadin-email-field.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';

@customElement('contact-view')
export class ContactView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;margin-left:10px;" id="vaadinVerticalLayout">
 <h2 style="padding: var(--lumo-space-xs); flex-grow: 0; flex-shrink: 1;" id="h2">Contáctenos</h2>
 <h5 id="h5" style="padding: var(--lumo-space-xs); flex-grow: 0; flex-shrink: 1;">Si tiene algún problema, necesita solicitar un servicio o quiere resolver una duda, utilice este formulario</h5>
 <div id="div" style="padding: var(--lumo-space-s); align-self: flex-start;">
  <vaadin-combo-box id="vaadinComboBox" style="padding: var(--lumo-space-s);"></vaadin-combo-box>
  <br>
  <vaadin-text-field type="text" id="vaadinTextField" style="padding: var(--lumo-space-s);"></vaadin-text-field>
  <vaadin-email-field type="email" id="vaadinEmailField" style="padding: var(--lumo-space-s);"></vaadin-email-field>
  <br>
  <vaadin-text-area placeholder="Añada los detalles que considere necesarios para su consulta." id="writeADescription" style="padding: var(--lumo-space-s);"></vaadin-text-area>
  <br>
  <span id="span" style="padding: var(--lumo-space-s); align-self: flex-end; flex-grow: 0;">
   <vaadin-button id="vaadinButton" style="padding: var(--lumo-space-m);" tabindex="0"></vaadin-button>
   <vaadin-button id="vaadinButton1" style="padding: var(--lumo-space-m);" tabindex="0"></vaadin-button></span>
 </div>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
