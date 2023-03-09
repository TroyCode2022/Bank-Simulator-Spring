import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/accordion/src/vaadin-accordion.js';

@customElement('faq-view')
export class FaqView extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <h2 id="h2" style="padding: var(--lumo-space-xs);">Preguntas Frecuentes</h2>
 <vaadin-accordion id="vaadinAccordion" style="padding: var(--lumo-space-s);"></vaadin-accordion>
 <vaadin-accordion id="vaadinAccordion1" style="padding: var(--lumo-space-s);"></vaadin-accordion>
 <vaadin-accordion id="vaadinAccordion2" style="padding: var(--lumo-space-s);"></vaadin-accordion>
 <vaadin-accordion id="vaadinAccordion3" style="padding: var(--lumo-space-s);"></vaadin-accordion>
 <vaadin-accordion id="vaadinAccordion4" style="padding: var(--lumo-space-s);"></vaadin-accordion>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
